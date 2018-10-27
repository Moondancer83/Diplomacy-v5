import Button from "@material-ui/core/Button/Button";
import TextField from "@material-ui/core/TextField/TextField";
import Typography from "@material-ui/core/Typography/Typography";
import * as React from "react";
import { connect } from "react-redux";
import authenticationActionCreator from "../store/authenticationActionCreator";
import "./login.css";
import { ILoginRequest, LoginRequest } from "./LoginRequest";
import Paper from "@material-ui/core/Paper/Paper";
import style from "../../style/style";

class Login extends React.Component<any, ILoginRequest> {
  public constructor(props: any) {
    super(props);
    this.state = new LoginRequest();
  }

  public render() {
    return (
      <Paper style={style.overlay}>
        <Paper style={style.login.box}>
          <form>
            <Typography variant="h2" align={"center"}>
              Login
            </Typography>
            <TextField
              id={"username"}
              required={true}
              label="User Name"
              margin="normal"
              onChange={this.onChange}
              value={this.state.username}
              fullWidth={true}
            />
            <TextField
              required={true}
              id="password"
              label="Password"
              margin="normal"
              type={"password"}
              onChange={this.onChange}
              value={this.state.password}
              fullWidth={true}
            />
            <Button
              variant="contained"
              color="primary"
              onClick={this.login}
              fullWidth={true}
            >
              Login
            </Button>
            <p />
            <Button onClick={this.reset} fullWidth={true}>
              Reset
            </Button>
          </form>
        </Paper>
      </Paper>
    );
  }

  private onChange = (event: any): void => {
    const state = {};
    state[event.target.id] = event.target.value;
    this.setState(state);
  };

  private login = () => {
    this.props.login(this.state.username, this.state.password);
  };

  private reset = () => {
    const state = new LoginRequest();
    this.setState({ ...state });
  };
}

const mapStateToProps = (state: any) => state;

const mapDispatchToProps = {
  login: authenticationActionCreator.login
};

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(Login);
