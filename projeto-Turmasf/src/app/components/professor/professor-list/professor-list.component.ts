import { Professor } from './../../../models/professor';
import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';
import { ProfessorService } from 'src/app/services/professor.service';

@Component({
  selector: 'app-professor-list',
  templateUrl: './professor-list.component.html',
  styleUrls: ['./professor-list.component.scss']
})
export class ProfessorListComponent implements OnInit {

  listarProf$ = new Observable<Professor[]>();

  constructor(private profService: ProfessorService) { }

  ngOnInit(): void {
    this.listarProf();
  }

  listarProf() {
    this.listarProf$ = this.profService.listarProf();
  }

  delete(id?: number){
    //let ret = this.alunoService.delete(id);
    console.log(id);
  }

}
