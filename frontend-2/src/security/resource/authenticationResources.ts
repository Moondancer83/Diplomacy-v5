class AuthenticationResources {
  public async login(username: string, password: string): Promise<any> {
    const response = await fetch("/login", {
      body: JSON.stringify({
        password,
        username
      }),
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json"
      },
      method: "POST"
    });
    return await response.json();
  }
}

export default new AuthenticationResources();
