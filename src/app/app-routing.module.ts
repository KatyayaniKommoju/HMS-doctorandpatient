import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomepageComponent } from './components/homepage/homepage.component';

const routes: Routes = [

  {path:'',component:HomepageComponent},

  { path: 'patient', loadChildren: () => import('./patient/patient.module').then(m => m.PatientModule) },

  { path: 'doctor', loadChildren: () => import('./doctor/doctor.module').then(m => m.DoctorModule) },

  { path: 'reception', loadChildren: () => import('./reception/reception.module').then(m => m.ReceptionModule) }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
