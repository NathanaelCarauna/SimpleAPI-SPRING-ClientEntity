package com.webservicetutorial.application.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservicetutorial.application.models.Client;
import com.webservicetutorial.application.services.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClientController {

	@Autowired
	ClienteService clienteService;

	@GetMapping
	public ResponseEntity<List<Client>> listClients() {
		return ResponseEntity.ok(clienteService.getAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Client> getById(@PathVariable int id) {
		Client client = clienteService.getById(id);
		if (client == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(client);
	}

	@PostMapping
	public ResponseEntity<Client> createClient(@RequestBody Client client) {
		if (client.getNome() == null || client.getNome().length() < 3) {
			return ResponseEntity.badRequest().build();
		}
		Client cliente = clienteService.createClient(client);
		return ResponseEntity.ok(cliente);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable int id, @RequestBody Client client) {
		Client cliente = clienteService.getById(id);
		if (cliente == null) {
			return ResponseEntity.notFound().build();
		}		
		clienteService.updateClient(id, client);
		cliente = clienteService.getById(id);
		return ResponseEntity.ok(client);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Client> removeClient(@PathVariable int id){
		Client client = clienteService.getById(id);
		if(client == null) {
			return ResponseEntity.notFound().build();
		}
		clienteService.removeClient(client);
		return ResponseEntity.ok(client);
	}
}
