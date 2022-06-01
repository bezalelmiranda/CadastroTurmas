package br.com.projetosaula.springprojetoturmas.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private int ano;
	
	@OneToOne
	@JoinColumn(name = "turma_id", nullable = true) //pode ser nulo
	//Relacionamento Turma ==> Aluno -- Quando pegar a Lista de Turma,  
	private Turma turma;
	
	@OneToOne
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;

	public Aluno() {}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
}
