import { Observable } from "rxjs";
import { Trainer } from "../model/trainer.model";
import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Student } from "src/app/student/model/student.model";
import { LoginService } from "src/app/login/service/admin.service";

@Injectable({
    providedIn: 'root'
  })
export class TrainerService {
    private getAllTrainersApi:string;
    private getTrainerAllInfoBytrainerId:string;
    private getStudentsBytrainerId:string;


    constructor(private http:HttpClient,private loginService:LoginService ) {
      this. getAllTrainersApi="http://localhost:1000/trainer-service/trainers/list";
      this.getTrainerAllInfoBytrainerId="http://localhost:1000/trainer-service/trainers/add/courses/";
      this.getStudentsBytrainerId="http://localhost:8003/users/get/list/";
    }


    gettllTrainers() : Observable<Trainer[]>{
     

      return this.http.get<Trainer[]>(this.getAllTrainersApi,{headers: { authorization: this.loginService.createBasicAuthToken(this.loginService.username, this.loginService.password) } });
  
    }

    getTrainerDetails(trainerId:number) : Observable<Trainer>{
        return this.http.post<Trainer>(this.getTrainerAllInfoBytrainerId+trainerId,{},{headers: { authorization: this.loginService.createBasicAuthToken(this.loginService.username, this.loginService.password) } });
    
      }

      getStudentsList(trainerId:number): Observable<Student[]>{
            return this.http.get<Student[]>(this.getStudentsBytrainerId+trainerId);

      }


}