import { Component, OnInit } from '@angular/core';
import { Course } from './model/courses.model';
import { CourseService } from './service/course.service';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.css']
})
export class CoursesComponent implements OnInit {
  courses:Course[];
  errorMsg:string;

  cartItem:number;

    constructor(private courseService:CourseService) {}

    ngOnInit(): void {



      this.courseService.getAllCourses().subscribe(data=>{
        this.courses=data;
        console.log(data);
      },
      error=>{
        this.errorMsg="Error in loading Courses, please contact administrator!"
      });

  }



}
 {

}