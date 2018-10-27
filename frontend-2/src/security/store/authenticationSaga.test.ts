import { saga } from "./authenticationSaga";
import { call, put, takeLatest } from "redux-saga/effects";
import { AuthenticationActionTypes } from "./AuthenticationActionTypes";
import ActionType from "../../core/ActionType";
import { LoginRequest } from "../container/LoginRequest";
import authenticationResources from "../resource/authenticationResources";

test("AuthenticationSaga.watchLogin should call AuthenticationSaga.login", () => {
  const gen = saga.watchLogin();
  const iteratorResult = gen.next();

  expect(iteratorResult.value).toEqual(
    takeLatest(AuthenticationActionTypes.LOGIN_REQUEST, saga.login)
  );
});

test("AuthenticationSaga.login should call authenticationResources.login", () => {
  const loginAction: ActionType<LoginRequest> = {
    type: "ACTION_TYPE",
    payload: {
      username: "USER", // NOSONAR
      password: "PASS" // NOSONAR
    },
    error: undefined,
    meta: undefined
  };
  const gen = saga.login(loginAction);
  const iteratorResult = gen.next();

  expect(iteratorResult.value).toEqual(
    call(authenticationResources.login, "USER", "PASS")
  );
});

test("AuthenticationSaga.login should put LOGIN_SUCCESS into store", () => {
  const loginAction: ActionType<LoginRequest> = {
    type: "ACTION_TYPE",
    payload: {
      username: "USER", // NOSONAR
      password: "PASS" // NOSONAR
    },
    error: undefined,
    meta: undefined
  };
  const gen = saga.login(loginAction);
  gen.next();
  const iteratorResult = gen.next();

  expect(iteratorResult.value).toEqual(
    put({
      type: AuthenticationActionTypes.LOGIN_SUCCESS,
      payload: {}
    })
  );
});
