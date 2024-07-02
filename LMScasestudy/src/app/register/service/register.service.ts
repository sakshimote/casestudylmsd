import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Admin } from "src/app/login/model/Admin.model";

@Injectable({
    providedIn: "root"
  })
  export class RegistrationService{
  
    private postRegistrationApi:string
  private getUsersApi:string
  
  
    constructor(private http: HttpClient){
      this.postRegistrationApi="http://localhost:8005/admins/post";
     this.getUsersApi="http://localhost:8005/admins/all";
  
    }
  
    public postRegistration(admin:Admin):Observable<Admin>{
      let tokenStr=localStorage.getItem("Authorization");
      return this.http.post<Admin>(this.postRegistrationApi,admin )
  
    }
  
    public getUsers():Observable<Admin[]>{
      let tokenStr=localStorage.getItem("Authorization");
      return this.http.get<Admin[]>(this.getUsersApi,{headers: { authorization:tokenStr}});
    }
  
  
  }
  