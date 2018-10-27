import * as React from "react";
import { connect } from "react-redux";
import authenticationActionCreator from "../store/authenticationActionCreator";
import authenticationSelector from "../store/authenticationSelector";
import Login from "./Login";

export class Authentication extends React.Component<any, any> {
  public componentWillMount() {
    this.props.login(undefined, undefined);
  }

  public render() {
    return this.props.isAuthenticated ? this.props.children : <Login />;
  }
}

const mapStateToProps = (state: any) => ({
  isAuthenticated: authenticationSelector.isAuthenticated(state)
});
const mapDispatchToProps = { login: authenticationActionCreator.login };

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(Authentication);
