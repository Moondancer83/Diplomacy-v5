import { all } from "redux-saga/effects";
import authenticationSaga from "./security/store/authenticationSaga";

export default function*() {
  yield all([authenticationSaga()]);
}
