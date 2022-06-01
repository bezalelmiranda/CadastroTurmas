INSERT INTO pessoa (nome, idade, endereco, sexo) VALUES ('Alex Miro da Silva', 42, 'Rua Paraíba', 'M');
INSERT INTO pessoa (nome, idade, endereco, sexo) VALUES ('Marcio Daniel', 38, 'Rua Quatorse de Setembro', 'M');
INSERT INTO pessoa (nome, idade, endereco, sexo) VALUES ('Ana Maria', 25, 'Rua Goiais', 'F');
INSERT INTO pessoa (nome, idade, endereco, sexo) VALUES ('Ramon Bombom', 32, 'Rua das Américas', 'M');

INSERT INTO professor (pessoa_id) VALUES (4);

INSERT INTO aluno (ano, pessoa_id) VALUES (3, 1);
INSERT INTO aluno (ano, pessoa_id) VALUES (3, 2);
INSERT INTO aluno (ano, pessoa_id) VALUES (4, 3);

INSERT INTO turma (nome, periodo, max_alunos, professor_id) VALUES ('Turma 1', 'Matutino', 20, 1);
INSERT INTO turma (nome, periodo, max_alunos, professor_id) VALUES ('Turma 2', 'Vespertino', 20, 1);
INSERT INTO turma (nome, periodo, max_alunos, professor_id) VALUES ('Turma 3', 'Noturno', 20, 1);