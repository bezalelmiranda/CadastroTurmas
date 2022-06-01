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

import br.com.projetosaula.springprojetoturmas.entity.Aluno;
import br.com.projetosaula.springprojetoturmas.entity.Pessoa;
import br.com.projetosaula.springprojetoturmas.repository.AlunoRepository;
import br.com.projetosaula.springprojetoturmas.repository.PessoaRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/aluno")
public class AlunoController {

	@Autowired
	AlunoRepository alunoRepository;
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	@GetMapping
	public List<Aluno> getAll() {
		return alunoRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Aluno> findById(@PathVariable Integer id) throws Exception {
		Aluno aluno = alunoRepository.findById(id)
				.orElseThrow(() -> new Exception("Id Aluno não encontrada!!"));
		return new ResponseEntity<Aluno>(aluno, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Aluno> addAluno(@RequestBody Aluno aluno) {
//		Pessoa pessoaAluno = pessoaRepository.save(aluno.getPessoa());
//		aluno.getPessoa().setId(pessoaAluno.getId());
//		aluno.setPessoa(pessoaAluno);
//		Aluno alunoResponse = alunoRepository.save(aluno);
//		Recebi um obj aluno recebendo informação para a tabela pessoa e aluno. É preciso ter Pessoa, para salvar um obj pessoa.
//		Set a pessoa em aluno e quando salvar o aluno, já terá o Id de pessoa. Então é salvo aluno na tabela aluno.
//		return new ResponseEntity<Aluno>(alunoResponse, HttpStatus.CREATED);		
	
		if (aluno.getPessoa().getId() == null) {
			Pessoa pessoaAluno = pessoaRepository.save(aluno.getPessoa());
			aluno.setPessoa(pessoaAluno);
		}
	
		return new ResponseEntity<Aluno>(alunoRepository.save(aluno), HttpStatus.CREATED);		
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteAluno(@PathVariable Integer id) throws Exception{
		
		Aluno aluno = alunoRepository.findById(id).orElseThrow(
				() -> new Exception("Registro não encontrado"));
		
		Pessoa pessoa = pessoaRepository.findById(aluno.getPessoa().getId())
				.orElseThrow(() -> new Exception ("Id Pessoa não encontrado"));
		
		alunoRepository.deleteById(id);
		pessoaRepository.deleteById(pessoa.getId());
		
		return true;
	}
}
