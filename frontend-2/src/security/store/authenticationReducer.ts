import ActionType from "../../core/ActionType";
import { AuthenticationActionTypes } from "./AuthenticationActionTypes";

interface IAuthenticationState {
  grantedAuthorities: string[];
  isAuthenticated: boolean;
  synergyGroups: string[];
  username: string | null;
}

const initialState: IAuthenticationState = {
  grantedAuthorities: [],
  isAuthenticated: false,
  synergyGroups: [],
  username: null
};

class AuthenticationReducer {
  public reduce(
    state: IAuthenticationState = { ...initialState },
    action: ActionType<any>
  ): any {
    let newState;
    switch (action.type) {
      case AuthenticationActionTypes.LOGIN_SUCCESS:
        newState = {
          ...state,
          ...action.payload
        };
        break;
      default:
        newState = { ...state };
        break;
    }

    return newState;
  }
}

export default new AuthenticationReducer().reduce;
