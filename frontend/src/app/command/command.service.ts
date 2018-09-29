import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {Command} from './command';

const httpOptions = {
  headers: new HttpHeaders({ 'Access-Control-Allow-Origin': '*' })
};

@Injectable()
export class CommandService {
  private resourceURL = 'http://localhost:9500/commands';

  constructor(private http: HttpClient) { }

  getCommands(): Observable<Command[]> {
    return this.http.get<Command[]>(this.resourceURL, httpOptions);
  }

}
