import { Observable } from 'rxjs';
import { environment } from './../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Aluno } from '../models/aluno';

@Injectable({
  providedIn: 'root'
})
export class AlunoService {

  urlApiAluno = `${environment.urlApiTurma}/aluno`;

  constructor(private http: HttpClient) { }

  listarAlunos() {
    return this.http.get<Aluno[]>(this.urlApiAluno);
  }

  getAlunoById(id: number) {
    return this.http.get<Aluno>(`${environment.urlApiTurma}/${id}`);
  }

  addAluno(aluno: Aluno): Observable<Aluno> {
    return this.http.post<Aluno>(this.urlApiAluno, aluno);
  }
}
