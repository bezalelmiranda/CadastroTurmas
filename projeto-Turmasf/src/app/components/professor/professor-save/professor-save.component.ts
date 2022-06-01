import { Professor } from './../../../models/professor';
import { Component, OnInit } from '@angular/core';
import { Pessoa } from 'src/app/models/pessoa';
import { ProfessorService } from 'src/app/services/professor.service';

@Component({
  selector: 'app-professor-save',
  templateUrl: './professor-save.component.html',
  styleUrls: ['./professor-save.component.scss']
})
export class ProfessorSaveComponent implements OnInit {

  okInsert: boolean = false;
  formProf: Professor = new Professor({turma: '',
                               pessoa: {sexo: ''}});

  constructor(private profService: ProfessorService) { }

  ngOnInit(): void {
  }

  addProf() {

    this.profService
      .addProf(this.formProf)
      .subscribe(
        (professor) => {
          if(!(typeof professor.id == 'undefined') &&
           professor.id > 0) {
            this.okInsert = true;

            setTimeout(()=>{this.okInsert = false;},3000);
          }
        }
      )
  }
}
