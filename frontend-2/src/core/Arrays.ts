export default class Arrays {
  public static containsAll(array: any[], values: any[]): boolean {
    return values.length === 0 || values.every(v => array.indexOf(v) > -1);
  }
}
