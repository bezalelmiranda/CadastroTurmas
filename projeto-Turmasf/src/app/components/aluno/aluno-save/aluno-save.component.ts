import { Component, OnInit } from '@angular/core';
import { Aluno } from 'src/app/models/aluno';
import { Pessoa } from 'src/app/models/pessoa';
import { AlunoService } from 'src/app/services/aluno.service';

@Component({
  selector: 'app-aluno-save',
  templateUrl: './aluno-save.component.html',
  styleUrls: ['./aluno-save.component.scss']
})
export class AlunoSaveComponent implements OnInit {

  okInsert: boolean = false;
  formAluno: Aluno = new Aluno({ano: 0,
                               pessoa: {sexo: ''}});

  constructor(private alunoService: AlunoService) { }

  ngOnInit(): void {
  }

  addAluno() {
    this.alunoService
      .addAluno(this.formAluno)
      .subscribe(
        (aluno) => {
          if(!(typeof aluno.id == 'undefined') &&
           aluno.id > 0) {
            this.okInsert = true;

            setTimeout(()=>{this.okInsert = false;},3000);
          }
        }
      )
  }

}
