import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { TrainerService } from '../trainer/service/trainer.service';
import { Trainer } from '../trainer/model/trainer.model';
import { Student } from '../student/model/student.model';

@Component({
  selector: 'app-trainer-details',
  templateUrl: './trainer-details.component.html',
  styleUrls: ['./trainer-details.component.css']
})
export class TrainerDetailsComponent implements OnInit {

trainerId:number;

students:Student[];

trainer:Trainer;
  constructor(private actRoute:ActivatedRoute,private trainerService:TrainerService ){}

  ngOnInit(): void {
    this.actRoute.params.subscribe(
      params=>{
        this.trainerId=params['trainerId'];
       this.trainerService.getTrainerDetails(params['trainerId']).subscribe(data=>{
         this.trainer=data})
         this.trainerService.getStudentsList(params['trainerId']).subscribe(data1=>{
          this.students=data1;
         })
  })


}
  }
