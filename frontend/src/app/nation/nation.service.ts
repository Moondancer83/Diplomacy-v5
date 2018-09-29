import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { Nation } from './nation';

const httpOptions = {
  headers: new HttpHeaders({ 'Access-Control-Allow-Origin': '*' })
};

@Injectable()
export class NationService {
  private resourceURL = 'http://localhost:9500/nations';

  constructor(private http: HttpClient) { }

  getNations(): Observable<Nation[]> {
    return this.http.get<Nation[]>(this.resourceURL, httpOptions);
  }

}
