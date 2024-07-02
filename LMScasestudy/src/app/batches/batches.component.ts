import { Component, OnInit } from '@angular/core';
import { Batch } from './model/batches.model';
import { BatchService } from './service/batches.service';

@Component({
  selector: 'app-batches',
  templateUrl: './batches.component.html',
  styleUrls: ['./batches.component.css']
})
export class BatchesComponent implements OnInit {

  batches:Batch[];
  errorMsg:string;

  

    constructor(private batchService:BatchService) {}

    ngOnInit(): void {

      this.batchService.getAllBatches().subscribe(data=>{
        this.batches=data;
        console.log(data);
      },
      error=>{
        this.errorMsg="Error in loading batches, please contact administrator!"
      });

  }



}
