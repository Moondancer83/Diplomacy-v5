import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {Unit} from './unit';

const httpOptions = {
  headers: new HttpHeaders({ 'Access-Control-Allow-Origin': '*' })
};

@Injectable()
export class UnitService {
  private resourceURL = 'http://localhost:9500/units';

  constructor(private http: HttpClient) { }

  getUnits(): Observable<Unit[]> {
    return this.http.get<Unit[]>(this.resourceURL, httpOptions);
  }

}
