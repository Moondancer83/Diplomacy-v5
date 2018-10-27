import * as React from "react";
import { connect } from "react-redux";
import Arrays from "../../core/Arrays";
import authenticationSelector from "../store/authenticationSelector";

interface IAuthorizationProps {
  required: string[];
  authorizations: string[];
}

export class Authorization extends React.Component<IAuthorizationProps, {}> {
  public render() {
    return Arrays.containsAll(this.props.authorizations, this.props.required)
      ? this.props.children
      : null;
  }
}

const mapStateToProps = (state: any) => ({
  authorizations: authenticationSelector.getAuthorities(state)
});

export default connect(mapStateToProps)(Authorization);
