import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
export class Employee{
  constructor(
    public Id:string,
    public name:string,
    public lastName:string,
    public designation:string,
  ){}
}


@Injectable({
  providedIn: 'root'
})
export class HttpClientService {

  constructor(private httpClient:HttpClient) 
  { }

 getEmployees()
{
console.log("test call");
return this.httpClient.get<Employee[]>('http://localhost:8080/employees');
}
}

