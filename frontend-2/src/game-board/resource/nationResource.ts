class NationResource {
  public async getNations(): Promise<any> {
    const response = await fetch("/nations", {
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json"
      },
      method: "GET"
    });
    return await response.json();
  }
}

export default new NationResource();
