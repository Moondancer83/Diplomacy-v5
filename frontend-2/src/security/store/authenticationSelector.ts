class AuthenticationSelector {
  public isAuthenticated = (state: any) => {
    return state.authentication.isAuthenticated;
  };

  public getAuthorities = (state: any) => {
    return state.authentication.grantedAuthorities;
  };
}

export default new AuthenticationSelector();
