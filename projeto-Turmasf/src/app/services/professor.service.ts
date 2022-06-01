import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Professor } from '../models/professor';

@Injectable({
  providedIn: 'root'
})
export class ProfessorService {

  urlApiProf = `${environment.urlApiTurma}/professor`;

  constructor(private http: HttpClient) { }

  listarProf() {
    return this.http.get<Professor[]>(this.urlApiProf);
  }

  getAlunoById(id: number) {
    return this.http.get<Professor>(`${environment.urlApiTurma}/${id}`);
  }

  addProf(professor: Professor): Observable<Professor> {
    console.log(professor);
    return this.http.post<Professor>(this.urlApiProf, professor);
  }
}
