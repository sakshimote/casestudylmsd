import { Component, OnInit } from '@angular/core';
import { CourseService } from '../courses/service/course.service';
import { ActivatedRoute } from '@angular/router';
import { Student } from '../student/model/student.model';

@Component({
  selector: 'app-course-details',
  templateUrl: './course-details.component.html',
  styleUrls: ['./course-details.component.css']
})
export class CourseDetailsComponent implements OnInit{

  courseId:number;
  students:Student[];


  noStudents:boolean=false;

constructor(private courseService:CourseService,private actRoute:ActivatedRoute){}


  ngOnInit(): void {
    this.actRoute.params.subscribe(
      params=>{
        this.courseId=params['courseId'];
       this.courseService.getStudentList(params['courseId']).subscribe(data=>{
         this.students=data;
         if(this.students.length==0){
          this.noStudents=true;
           }}
         )

         
         })


       
    
  }

}
