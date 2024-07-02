import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CoursesComponent } from './courses/courses.component';
import { StudentComponent } from './student/student.component';
import { TrainerComponent } from './trainer/trainer.component';
import { BatchesComponent } from './batches/batches.component';
import { TrainerDetailsComponent } from './trainer-details/trainer-details.component';
import { CourseDetailsComponent } from './course-details/course-details.component';
import { BatchDetailsComponent } from './batch-details/batch-details.component';
import { AuthGuard } from './login/service/auth.gaurd';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';

const routes: Routes = [
  {path:'',component:TrainerComponent,canActivate: [AuthGuard]},
 // {path:'students',component:StudentComponent},
 {path:'login',component:LoginComponent},
 {path:'user/register',component:RegisterComponent},
  {path:'courses',component:CoursesComponent},
  {path:'batches',component:BatchesComponent},
  {path:'trainerDetails/:trainerId',component:TrainerDetailsComponent},
  {path:':courseId',component:CourseDetailsComponent},
  {path:'details/:batchId',component:BatchDetailsComponent},
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
