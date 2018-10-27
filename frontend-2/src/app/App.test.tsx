import * as React from "react";
import * as ReactDOM from "react-dom";
import App from "./App";

beforeEach(() => {
  window.history.pushState({}, "Test", "/next");
});

it("App renders without crashing", () => {
  const div = document.createElement("div");
  ReactDOM.render(<App />, div);
  ReactDOM.unmountComponentAtNode(div);
});
