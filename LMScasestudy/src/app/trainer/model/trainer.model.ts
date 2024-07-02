import { TrainingCourses } from "./TrainingCourses.model"


export interface Trainer{
    trainerId?:number,
    firstName?:string,
    lastName?:string,
    engagedHours?:number,
    courseList?:TrainingCourses[],
    batches?:Batches[],
    designation?:string,
    expertise?:string
  
  }

  
  export interface Batches{
    id?:number,
    batchId?:number,
    batchName?:string,
    courseId?:number,
    batchStartDate?:Date,
    batchEndDate?:Date,
    trainingOn?:string,
    trainingBy?:string

  }
  