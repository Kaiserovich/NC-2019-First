import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Status} from "../models/status";

@Injectable({
  providedIn: 'root'
})
export class StatusService {

  constructor(private http: HttpClient) { }

  getStatus(): Observable<Status[]>{
    return this.http.get<Status[]>("/api/status/");

  }


  findByIdStatus(name:string): any{
    return this.http.get("/api/status/status/" + name);
  }

  findByName(name:string): any{
    return this.http.get("/api/status/name/" + name);
  }
}
