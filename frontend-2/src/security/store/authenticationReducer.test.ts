import reducers from "./authenticationReducer";

test("reducers", () => {
  let state;
  state = reducers(
    {
      grantedAuthorities: [],
      isAuthenticated: false,
      synergyGroups: [],
      username: ""
    },
    {
      error: false,
      meta: null,
      payload: {
        grantedAuthorities: ["ROLE"],
        isAuthenticated: true,
        synergyGroups: ["GROUP"],
        username: "admin"
      },
      type: "LOGIN_SUCCESS"
    }
  );
  expect(state).toEqual({
    grantedAuthorities: ["ROLE"],
    isAuthenticated: true,
    synergyGroups: ["GROUP"],
    username: "admin"
  });
});
