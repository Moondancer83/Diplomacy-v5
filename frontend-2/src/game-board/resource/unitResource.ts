class UnitResource {
  public async getUnits(): Promise<any> {
    const response = await fetch("/units", {
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json"
      },
      method: "GET"
    });
    return await response.json();
  }
}

export default new UnitResource();
