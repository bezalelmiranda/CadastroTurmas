package br.com.projetosaula.springprojetoturmas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetosaula.springprojetoturmas.entity.Pessoa;
import br.com.projetosaula.springprojetoturmas.entity.Professor;
import br.com.projetosaula.springprojetoturmas.repository.PessoaRepository;
import br.com.projetosaula.springprojetoturmas.repository.ProfessorRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/professor")
public class ProfessorController {

	@Autowired
	ProfessorRepository professorRepository;
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	@GetMapping
	public List<Professor> getAll(){
		return professorRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Professor> addProfessor(@RequestBody Professor professor) throws Exception {
		
		if (professor.getPessoa().getId() == null) {
			Pessoa pessoaProfessor = pessoaRepository.save(professor.getPessoa());
			professor.setPessoa(pessoaProfessor);
		} else {
			Pessoa pessoaVerificacao = pessoaRepository.findById(professor.getPessoa().getId())
					.orElseThrow(() -> new Exception("Pessoa não existe"));
			professor.setPessoa(pessoaVerificacao);
		}
	
		Professor professorResponse = professorRepository.save(professor);
		
		return	new ResponseEntity<Professor>(professorResponse, HttpStatus.CREATED);		
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteAluno(@PathVariable Integer id) throws Exception{
		
		pessoaRepository.findById(id).orElseThrow(
				() -> new Exception("Registro não encontrado"));
		
		pessoaRepository.deleteById(id);
		
		return true;
	}
}
