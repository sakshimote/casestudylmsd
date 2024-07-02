import { Component, OnInit } from '@angular/core';
import { StudentService } from './service/student.service';
import { Student } from './model/student.model';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent  implements OnInit{



  students:Student[];
  errorMsg:string
  constructor(private studentService:StudentService){}

  ngOnInit():void{
    this.studentService.getAllStudents().subscribe(data=>{
      this.students=data;
      console.log(data);
    },
    error=>{
      this.errorMsg="Error in loading Courses, please contact administrator!"
    });
  }



  

}
