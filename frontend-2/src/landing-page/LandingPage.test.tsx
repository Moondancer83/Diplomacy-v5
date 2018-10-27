import { shallow } from "enzyme";
import * as React from "react";
import LandingPage from "./LandingPage";

test("LandingPage", () => {
  const wrapper = shallow(<LandingPage />);
  const paper = wrapper.find("#landing-page-container");
  expect(paper.exists()).toBeTruthy();
  expect(paper.children().length).toBe(4);
});
