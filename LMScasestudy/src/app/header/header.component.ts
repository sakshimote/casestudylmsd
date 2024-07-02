import { Component } from '@angular/core';
import { AppService } from '../app.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {

  loggedIn: boolean=true;

  constructor(private appService:AppService,private router:Router){
    
  }

  onLogOut(){
    // this.appService.cartItems.next(0);
    // this.appService.isMerchant.next(false);
    localStorage.removeItem('token');
    localStorage.removeItem('isLoggedIn');
    localStorage.removeItem('userId');
    localStorage.removeItem('userRole');
    this.loggedIn = false;
    alert("user logged out");
    this.router.navigateByUrl('/login');
  }

}
