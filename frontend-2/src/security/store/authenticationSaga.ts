import { all, call, put, takeLatest } from "redux-saga/effects";
import ActionType from "../../core/ActionType";
import authenticationResources from "../resource/authenticationResources";
import { AuthenticationActionTypes } from "./AuthenticationActionTypes";
import { ILoginRequest } from "../container/LoginRequest";

class AuthenticationSaga {
  public *watchLogin() {
    yield takeLatest(AuthenticationActionTypes.LOGIN_REQUEST, this.login);
  }

  public *login(action: ActionType<ILoginRequest>) {
    let username: string | undefined;
    let password: string | undefined;
    if (action.payload) {
      username = action.payload.username;
      password = action.payload.password;
    }
    const userDetails = yield call(
      authenticationResources.login,
      username,
      password
    );
    yield put({
      type: AuthenticationActionTypes.LOGIN_SUCCESS,
      payload: { ...userDetails }
    });
  }
}

export const saga = new AuthenticationSaga();
export default function* authenticationSaga() {
  yield all([saga.watchLogin()]);
}
