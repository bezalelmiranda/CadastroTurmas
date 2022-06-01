import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Aluno } from 'src/app/models/aluno';
import { AlunoService } from 'src/app/services/aluno.service';

@Component({
  selector: 'app-aluno-list',
  templateUrl: './aluno-list.component.html',
  styleUrls: ['./aluno-list.component.scss']
})
export class AlunoListComponent implements OnInit {

  listarAlunos$ = new Observable<Aluno[]>();

  constructor(private alunoService: AlunoService) { }

  ngOnInit(): void {
    this.listarAlunos();
  }

  listarAlunos() {
    this.listarAlunos$ = this.alunoService.listarAlunos();
  }

  delete(id?: number){
    //let ret = this.alunoService.delete(id);
    console.log(id);
  }
}
