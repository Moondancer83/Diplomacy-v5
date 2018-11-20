class CommandResource {
  public async getCommands(): Promise<any> {
    const response = await fetch("/commands", {
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json"
      },
      method: "GET"
    });
    return await response.json();
  }
}

export default new CommandResource();
