export default class ActionType<T> {
  public type: string;
  public payload: T | undefined;
  public error: boolean | undefined;
  public meta: any | undefined;
}
