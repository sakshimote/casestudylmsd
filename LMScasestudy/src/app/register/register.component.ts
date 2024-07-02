import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Admin } from '../login/model/Admin.model';
import { RegistrationService } from './service/register.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private registrationService:RegistrationService,
    private router:Router ){}


  registrationForm:FormGroup;
  admin:Admin;
  admins:Admin[];


  ngOnInit(): void {
 this.registrationService.getUsers().subscribe(data=>{
      this.admins=data;


    });

    this.registrationForm=new FormGroup({
      
      username:new FormControl('',Validators.required),
      password:new FormControl('',Validators.required),
     
      role:new FormControl('',Validators.required),
     
    });

    
  }


  onPostRegistration(){

  

    this.admin={
   
      username:this.registrationForm.value.username,
      password:this.registrationForm.value.password,
      role:this.registrationForm.value.role,
    
    }


    this.registrationService.postRegistration(this.admin).subscribe(data=>{
      this.admins.push(data);

    })
    alert("Registration successful!!")
    this.router.navigateByUrl("/login");
  }

  }



