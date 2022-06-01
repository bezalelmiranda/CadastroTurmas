import { Pessoa } from "./pessoa";

export class Professor {
  id?: number;
  turma?: string;
  pessoa: Pessoa = new Pessoa({});

    constructor(obj: Partial<Professor>) {
      Object.assign(this, obj);
    }


}

