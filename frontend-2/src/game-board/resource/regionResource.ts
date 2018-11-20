class RegionResource {
  public async getRegions(): Promise<any> {
    const response = await fetch("/regions", {
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json"
      },
      method: "GET"
    });
    return await response.json();
  }
}

export default new RegionResource();
