import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AlunoListComponent } from './components/aluno/aluno-list/aluno-list.component';
import { AlunoSaveComponent } from './components/aluno/aluno-save/aluno-save.component';
import { HomeComponent } from './components/home/home.component';
import { ProfessorListComponent } from './components/professor/professor-list/professor-list.component';
import { ProfessorSaveComponent } from './components/professor/professor-save/professor-save.component';


const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'professor-list', component: ProfessorListComponent},
  { path: 'professor-save', component: ProfessorSaveComponent},
  { path: 'aluno-list', component: AlunoListComponent},
  { path: 'aluno-save', component: AlunoSaveComponent},
  { path: '', redirectTo: '/home', pathMatch: 'full' }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
