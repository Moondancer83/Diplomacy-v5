import { shallow } from "enzyme";
import * as React from "react";
import { Authentication } from "./Authentication";

let loginMock: any;
let wrapper: any;
let isAuthenticated: boolean;

beforeEach(() => {
  loginMock = jest.fn(() => {
    /* MOCK */
  });
});

test("Authentication should render children when authenticated", () => {
  isAuthenticated = true;
  wrapper = shallow(
    <Authentication isAuthenticated={isAuthenticated} login={loginMock}>
      <p>Authenticated</p>
    </Authentication>
  );

  expect(wrapper.children().length).toBe(1);
  expect(wrapper.text()).toBe("Authenticated");
});

test("Authentication should render Login dialog when unauthenticated", () => {
  isAuthenticated = false;
  wrapper = shallow(
    <Authentication isAuthenticated={isAuthenticated} login={loginMock}>
      <p>Authenticated</p>
    </Authentication>
  );

  expect(wrapper.children().length).toBe(0);
  expect(wrapper.text()).toBe("<Connect(Login) />");
});

test("Authentication should check if user is logged in on mount", () => {
  isAuthenticated = false;
  wrapper = shallow(
    <Authentication isAuthenticated={isAuthenticated} login={loginMock}>
      <p>Authenticated</p>
    </Authentication>
  );

  expect(loginMock.mock.calls.length).toBe(1);
});
