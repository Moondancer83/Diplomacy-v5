import { Observable} from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import {Region} from './region';
import {Injectable} from '@angular/core';

const httpOptions = {
  headers: new HttpHeaders({ 'Access-Control-Allow-Origin': '*' })
};

@Injectable()
export class RegionService {
  private resourceURL = 'http://localhost:9500/regions';

  constructor(private http: HttpClient) { }

  getRegions(): Observable<Region[]> {
    return this.http.get<Region[]>(this.resourceURL, httpOptions);
  }

}
