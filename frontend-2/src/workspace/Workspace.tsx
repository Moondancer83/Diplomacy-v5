import * as React from "react";
import { Route, RouteComponentProps, withRouter } from "react-router";
import AppHeader from "../app-header/AppHeader";
import Dashboard from "../dashboard/Dashboard";
import Authentication from "../security/container/Authentication";
import Grid from "@material-ui/core/Grid/Grid";

class Workspace extends React.Component<RouteComponentProps> {
  constructor(props: RouteComponentProps) {
    super(props);
  }

  public render() {
    return (
      <Authentication>
        <AppHeader />
        {/* Main Content Starts */}
        <Grid container={true} spacing={16}>
          <Route
            exact={true}
            path={this.props.match.path + "/"}
            component={Dashboard}
          />
        </Grid>
        {/* Main Content Ends */}
      </Authentication>
    );
  }
}

export default withRouter(Workspace);
