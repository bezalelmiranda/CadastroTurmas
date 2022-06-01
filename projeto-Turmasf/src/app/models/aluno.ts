import { Pessoa } from "./pessoa";

export class Aluno {
    id?: number;
    ano?: number;
    turma?: string;
    pessoa: Pessoa = new Pessoa({});

    constructor(obj: Partial<Aluno>) {
      Object.assign(this, obj);
    }
}

