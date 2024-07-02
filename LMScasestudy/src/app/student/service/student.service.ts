import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Student } from "../model/student.model";

@Injectable({
    providedIn: 'root'
  })
  
  export class StudentService {
      private getAllStudentsApi:string;
     // private getCourseByCourseIdApi:string;


      constructor(private http:HttpClient ) {
        this. getAllStudentsApi="http://localhost:1000/user-service/users/get/list";
        //this.getCourseByCourseIdApi="http://localhost:1000/course-service/courses/get/1";
    
    
      }


      getAllStudents() : Observable<Student[]>{
        return this.http.get<Student[]>(this.getAllStudentsApi);
    
      }


  }