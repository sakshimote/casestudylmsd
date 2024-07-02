import { Component, OnInit } from '@angular/core';
import { Trainer } from './model/trainer.model';
import { TrainerService } from './service/trainer.service';

@Component({
  selector: 'app-trainer',
  templateUrl: './trainer.component.html',
  styleUrls: ['./trainer.component.css']
})
export class TrainerComponent implements OnInit{


  trainers:Trainer[];
  errorMsg:string;


    constructor(private trainerService:TrainerService) {}

    ngOnInit(): void {
      this.trainerService.gettllTrainers().subscribe(data=>{
        this.trainers=data;
        console.log(data);
      },
      error=>{
        this.errorMsg="Error in loading trainers, please contact administrator!"
      });

  }


}
