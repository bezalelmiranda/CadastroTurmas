package br.com.projetosaula.springprojetoturmas.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Turma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String periodo;
	private int maxAlunos;
	
	@OneToMany(mappedBy = "turma")
	//Relacionamento Turma ==> Aluno -- Quando pegar a Lista de Aluno,  
	private List<Aluno> alunos;
	
	@OneToOne
	@JoinColumn(name = "professor_id")
	private Professor professor;
	
	public Turma() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public int getMaxAlunos() {
		return maxAlunos;
	}

	public void setMaxAlunos(int maxAlunos) {
		this.maxAlunos = maxAlunos;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		if(alunos.size() <= getMaxAlunos()) {
			this.alunos = alunos;			
		}
	}
	
	public void addAluno(Aluno aluno) {
		if(getAlunos().size() < getMaxAlunos()) {
			getAlunos().add(aluno);
		}
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	
		
}
