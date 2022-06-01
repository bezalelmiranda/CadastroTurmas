import { Aluno } from "./aluno";

export class Pessoa {
  id?: number;
  nome?: string;
  idade?: number;
  endereco?: string;
  sexo?: string;
  pessoa?: Pessoa;

  constructor(obj: Partial<Aluno>) {
    Object.assign(this, obj);
  }

}
