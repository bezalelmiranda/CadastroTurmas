package br.com.projetosaula.springprojetoturmas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetosaula.springprojetoturmas.entity.Pessoa;
import br.com.projetosaula.springprojetoturmas.repository.PessoaRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {

	@Autowired
	PessoaRepository pessoaRepository;
	
	@GetMapping
	public List<Pessoa> getAll() {
		return pessoaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Pessoa getPessoaById(@PathVariable("id") Integer id) throws Exception {
		Pessoa pessoa = pessoaRepository.findById(id)
				.orElseThrow(() -> new Exception("Pessoa não encontrado com o id= " + id));
	return pessoa;
	}
	
//	Insert
	@PostMapping
	public ResponseEntity<Pessoa> addPessoa(@RequestBody Pessoa pessoa) throws Exception {
//		Interface com o banco para fazer todas as operação, no caso (persistir) salvar no banco
//		método save(entity) para salvar o objeto no banco
		Pessoa pessoaResponse = pessoaRepository.save(pessoa);
		
		return new ResponseEntity<Pessoa>(pessoaResponse, HttpStatus.CREATED);
//		devolve o status 200 que é o status OK, quando da tudo certo no banco, no corpo da resposta trás as informações de resposta
	}
}
