package br.com.senac.siscomee.rest.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import br.com.senac.siscomee.model.services.FornecedorService;

import br.com.senac.siscomee.model.entidades.Fornecedores;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FornecedorController.class);

    @Autowired
    private FornecedorService fornecedorService;

	@ApiOperation(value="método p/ listar todos os fornecedores")
	@RequestMapping(path = "/listarTodos", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> listarFornecedores() {
		try {
			return ResponseEntity.ok(fornecedorService.listarFornecedores());
		}catch (Exception e) {
			LOGGER.error("Erro ao listar todos fornecedores!", e);
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
    
	@ApiOperation(value="método p/ adicionar os fornecedores")
    @PostMapping("/adicionar")
	public Fornecedores addFornecedor (@RequestBody Fornecedores fornecedor)
    {
		return fornecedorService.addFornecedor(fornecedor);
	}
		
	@ApiOperation(value="método p/ combo (ramo setores)")
	@RequestMapping(path = "/ramoSetores", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getRamoSetores() {
		try {
			return ResponseEntity.ok(fornecedorService.getRamoSetores());
		}catch (Exception e) {
			LOGGER.error("Erro ao listar ramos setores!", e);
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@ApiOperation(value="método p/ filtrar")
	@GetMapping(path = "/filtrar/{idRamo}/{nmFornecedor}/{situacao}", produces = "application/json")
	public ResponseEntity<?> filtrar(@PathVariable int idRamo, @PathVariable String nmFornecedor, @PathVariable int situacao) {	
		try {
			return ResponseEntity.ok(fornecedorService.filtrarFornecedores(idRamo, nmFornecedor, situacao));
		}catch (Exception e) {
			LOGGER.error("Erro ao filtrar!", e);
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@ApiOperation(value="método p/ unicidade")
	@GetMapping(path = "/unicidade/{idRamo}/{nmFornecedor}/{idFornecedor}", produces = "application/json")
	public ResponseEntity<?> unicidade(@PathVariable int idRamo, @PathVariable String nmFornecedor, @PathVariable String idFornecedor) {	
		try {
			return ResponseEntity.ok(fornecedorService.unicidade(idRamo, nmFornecedor, idFornecedor));
		}catch (Exception e) {
			LOGGER.error("Erro ao listar todos!", e);
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@ApiOperation(value="método p/ editar os fornecedores")
	@PutMapping("/editar")
	public Fornecedores atualizarFornecedor(@RequestBody Fornecedores fornecedor)
	{
		return fornecedorService.atualizarFornecedor(fornecedor);
	}
	
	@ApiOperation(value="método p/ inativar")
	@GetMapping(path = "/inativar/{id}", produces = "application/json")
	public ResponseEntity<?> inativarFornecedorByID(@PathVariable int id) {	
		try {
			return ResponseEntity.ok(fornecedorService.inativarFornecedorByID(id));
		}catch (Exception e) {
			LOGGER.error("Erro ao inativar!", e);
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	}