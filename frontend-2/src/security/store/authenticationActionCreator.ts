import IActionType from "../../core/ActionType";
import { ILoginRequest } from "../container/LoginRequest";
import { AuthenticationActionTypes } from "./AuthenticationActionTypes";

/* tslint:disable:object-literal-sort-keys */

class AuthenticationActionCreator {
  public login(
    username: string | undefined,
    password: string | undefined
  ): IActionType<ILoginRequest> {
    return {
      type: AuthenticationActionTypes.LOGIN_REQUEST,
      payload: {
        username,
        password
      },
      error: false,
      meta: null
    };
  }
}

/* tslint:enable:object-literal-sort-keys */

export default new AuthenticationActionCreator();
