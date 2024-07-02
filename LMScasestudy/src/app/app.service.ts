import { Injectable } from "@angular/core";
import { BehaviorSubject } from "rxjs";

@Injectable({
    providedIn: 'root'
  })
  export class AppService{
  
    loggedIn = new BehaviorSubject<boolean>(false);
    // isMerchant=new BehaviorSubject<boolean>(false);
    // cartItems = new BehaviorSubject<number>(0);
    // reviewCount=new BehaviorSubject<number>(0);
    //productId:string;
  
     constructor() {
        let user = localStorage.getItem('token');
      //  let role = localStorage.getItem('userRole');
  
        if(user){
          this.loggedIn.next(true);
  
          
  

        }
  
      }
  
  
  }