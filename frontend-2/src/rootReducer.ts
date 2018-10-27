import { combineReducers } from "redux";
import authenticationReducer from "./security/store/authenticationReducer";

class RootReducer {
  public get() {
    return combineReducers({
      authentication: authenticationReducer
    });
  }
}

export default new RootReducer().get();
