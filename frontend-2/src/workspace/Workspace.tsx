import * as React from "react";
import { Route, withRouter } from "react-router";
import AppHeader from "../app-header/AppHeader";
import Dashboard from "../dashboard/Dashboard";
import Authentication from "../security/container/Authentication";

class Workspace extends React.Component<any, any> {
  constructor(props: any) {
    super(props);
  }

  public render() {
    return (
      <Authentication>
        <AppHeader />
        {/* Main Content Starts */}
        <Route
          exact={true}
          path={this.props.match.path + "/"}
          component={Dashboard}
        />
        {/* Main Content Ends */}
      </Authentication>
    );
  }
}

export default withRouter(Workspace);
