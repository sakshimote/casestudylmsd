import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from "@angular/router";

@Injectable({
    providedIn: 'root'
  })
  export class AuthGuard implements CanActivate{
  
    constructor(private router: Router){
  
    }
    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean  {
      //if loggedIN??
      let token = localStorage.getItem('token');
      if(token){
        return true;
      }
      this.router.navigateByUrl("/login");
      return false;
    }
  
  }