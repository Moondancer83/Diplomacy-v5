import { shallow } from "enzyme";
import * as React from "react";
import { Authorization } from "./Authorization";

let requiredAuthorizations: string[];
let grantedAuthorizations: string[];

test("Authorization should render children when authorization is not needed", () => {
  requiredAuthorizations = [];
  grantedAuthorizations = ["ROLE"];

  const wrapper = shallow(
    <Authorization
      required={requiredAuthorizations}
      authorizations={grantedAuthorizations}
    >
      <p>Authorized</p>
    </Authorization>
  );
  expect(wrapper.children().length).toBe(1);
});

test("Authorization should render null when unauthorized", () => {
  requiredAuthorizations = ["ROLE"];
  grantedAuthorizations = [];

  const wrapper = shallow(
    <Authorization
      required={requiredAuthorizations}
      authorizations={grantedAuthorizations}
    >
      <p>Authorized</p>
    </Authorization>
  );
  expect(wrapper.children().length).toBe(0);
});

test("Authorization should render children when authorized", () => {
  requiredAuthorizations = ["ROLE"];
  grantedAuthorizations = ["ROLE"];

  const wrapper = shallow(
    <Authorization
      required={requiredAuthorizations}
      authorizations={grantedAuthorizations}
    >
      <p>Authorized</p>
    </Authorization>
  );
  expect(wrapper.children().length).toBe(1);
});
