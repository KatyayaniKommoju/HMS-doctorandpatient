import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DoctorComponent } from './doctor.component';
import { AppointmentComponent } from './appointment/appointment.component';
import { HomeComponent } from './home/home.component';
const routes: Routes = [
  { path: '', component: DoctorComponent,

  children:[
    {path:'',component:HomeComponent},
    {path:'appointment',component:AppointmentComponent}, ]}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DoctorRoutingModule { }
