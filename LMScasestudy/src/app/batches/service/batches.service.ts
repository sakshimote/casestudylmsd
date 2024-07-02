import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Batch } from "../model/batches.model";
import { Observable } from "rxjs";
import { Student } from "src/app/student/model/student.model";

@Injectable({
    providedIn: 'root'
  })
  
  export class BatchService {
      private getAllBatchesApi:string;
     private getstudentsByBatchId:string;


      constructor(private http:HttpClient ) {
        this.getAllBatchesApi="http://localhost:8004/batches/get/list";
       this.getstudentsByBatchId="http://localhost:8003/users/get/batch/";
    
    
      }


      getAllBatches() : Observable<Batch[]>{
        return this.http.get<Batch[]>(this.getAllBatchesApi);
    
      }

      getStudentListByBatch(batchId:number):Observable<Student[]>{
        return this.http.get<Student[]>(this.getstudentsByBatchId+batchId);
      }


      


  }