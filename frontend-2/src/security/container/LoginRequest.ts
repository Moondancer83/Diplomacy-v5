export interface ILoginRequest {
  password: string | undefined;
  username: string | undefined;
}

export class LoginRequest implements ILoginRequest {
  public password = "";
  public username = "";
}
