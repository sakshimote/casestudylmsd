import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Course } from "../model/courses.model";
import { Student } from "src/app/student/model/student.model";

@Injectable({
    providedIn: 'root'
  })
  
  export class CourseService {
      private getAllCoursesApi:string;
      private getCourseByCourseIdApi:string;

      private getStudentListBycourseId:string;


      constructor(private http:HttpClient ) {
        this. getAllCoursesApi="http://localhost:1000/course-service/courses/get";
        this.getCourseByCourseIdApi="http://localhost:1000/course-service/courses/get/1";
        this.getStudentListBycourseId="http://localhost:8003/users/get/";
    
      }


      getAllCourses() : Observable<Course[]>{
        return this.http.get<Course[]>(this.getAllCoursesApi);
    
      }

      getStudentList(courseId:number):Observable<Student[]>{
        return this.http.get<Student[]>(this.getStudentListBycourseId+courseId);
      }


  }