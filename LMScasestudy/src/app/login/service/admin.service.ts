import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Router } from "@angular/router";
import { Observable } from "rxjs";
import { map } from "rxjs/internal/operators/map";
import { Admin } from "../model/Admin.model";

@Injectable({
    providedIn: 'root'
  })

  
  export class LoginService{
    USER_NAME_SESSION_ATTRIBUTE_NAME = 'authenticatedUser'
  
    public username: string;
    public password: string;
  
    getUserApi:string;
  
    constructor(private http:HttpClient,private router:Router) {
      this.getUserApi="http://localhost:8005/admins/get/";
      this.username="";
      this.password="";
   }
  
   authenticationService(username: string, password: string) {
    return this.http.get(this.getUserApi+username,
      { headers: { authorization: this.createBasicAuthToken(username, password) } }).pipe(map((res) => {
        this.username = username;
        this.password = password;
        this.registerSuccessfulLogin(username, password);
      }));
  }
  
  createBasicAuthToken(username: string, password: string) {
    return 'Basic ' + window.btoa(username + ":" + password)
  }
  
  registerSuccessfulLogin(username:string, password:string) {
    localStorage.setItem("auth",this.createBasicAuthToken(username,password))
    sessionStorage.setItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME,username);
  }
  
  isUserLoggedIn() {
    let user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME)
    if (user === null) return false
    return true
  }
  
  getLoggedInUserName() {
    let user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME)
    if (user === null) return ''
    return user
  }
  
  getUserByUsername(username:string):Observable<Admin>{
    let token1:string|null=localStorage.getItem("auth");
    let token="";
    console.log(token1);
    return this.http.get<Admin>(this.getUserApi+username, { headers: { authorization:token1 || token} });
   }
  
  
  }