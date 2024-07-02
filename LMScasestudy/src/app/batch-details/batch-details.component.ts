import { Component, OnInit } from '@angular/core';
import { Student } from '../student/model/student.model';
import { ActivatedRoute } from '@angular/router';
import { BatchService } from '../batches/service/batches.service';

@Component({
  selector: 'app-batch-details',
  templateUrl: './batch-details.component.html',
  styleUrls: ['./batch-details.component.css']
})
export class BatchDetailsComponent implements OnInit{

  batchId:number;
  students:Student[];


  noStudents:boolean=false;

  constructor(private actRoute:ActivatedRoute,private batchService:BatchService){}

  ngOnInit(): void {

    this.actRoute.params.subscribe(
      params=>{
        this.batchId=params['batchId'];
       this.batchService.getStudentListByBatch(params['batchId']).subscribe(data=>{
         this.students=data;
         if(this.students.length==0){
          this.noStudents=true;
           }}
         )

         
         })


   
  }

  

  

}
