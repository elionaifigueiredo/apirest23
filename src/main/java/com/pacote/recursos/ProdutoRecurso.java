package com.pacote.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pacote.model.Produto;
import com.pacote.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value = "API REST Produtos")
@CrossOrigin(origins = "*") // qualquer aplicação pode acessar essa api
//@CrossOrigin(origins = "https://dominio.com") libera o acesso apenas para um dominio
public class ProdutoRecurso {

	@Autowired
	ProdutoRepository repository;

	@GetMapping("/hello")
	public String hello() {
		return "Hello World Manaus";
	}

	@GetMapping("/lista")
	@ApiOperation(value = "Retorna uma lista de Produtos.")
	public List<Produto> ListaProdutos() {
		return repository.findAll();
	}

	@GetMapping("/produto/{id}")
	@ApiOperation(value = "Retorna um Produto único.")
	public Produto listaProdutoUnico(@PathVariable(value = "id") long id) {
		return repository.findById(id);
	}

	@PostMapping("/produto")
	@ApiOperation(value = "Salva um Produto.")
	public Produto saveProduto(@RequestBody Produto produto) {
		return repository.save(produto);

	}

	@DeleteMapping("/produto")
	@ApiOperation(value = "Deleta um Produto.")
	public void deletaProduto(@RequestBody Produto produto) {
		repository.delete(produto);
	}

	@PutMapping("/produto")
	@ApiOperation(value = "Atualiza um Produto.")
	public Produto atualizaProduto(@RequestBody Produto produto) {
		return repository.save(produto);
	}

}
