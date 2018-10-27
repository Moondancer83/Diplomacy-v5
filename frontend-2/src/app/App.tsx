import CssBaseline from "@material-ui/core/CssBaseline";
import MuiThemeProvider from "@material-ui/core/styles/MuiThemeProvider";
import * as React from "react";
import { BrowserRouter, Route, Switch } from "react-router-dom";
import "typeface-roboto";
import LandingPage from "../landing-page/LandingPage";
import Login from "../security/container/Login";
import Workspace from "../workspace/Workspace";
import diplomacyTheme from "../style/diplomacyTheme";

class App extends React.Component {
  public render() {
    return (
      <MuiThemeProvider theme={diplomacyTheme}>
        <CssBaseline />
        <BrowserRouter basename="/">
          <Switch>
            <Route exact={true} path="/" component={LandingPage} />
            <Route path="/login" component={Login} />
            <Route path="/auth" component={Workspace} />
            <Workspace />
          </Switch>
        </BrowserRouter>
      </MuiThemeProvider>
    );
  }
}

export default App;
