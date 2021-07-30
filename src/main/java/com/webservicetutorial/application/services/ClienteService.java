package com.webservicetutorial.application.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.webservicetutorial.application.models.Client;

@Service
public class ClienteService {
	
	List<Client> clientList;
	
	
	
	public ClienteService() {
		clientList = new ArrayList<>();
		clientList.add(new Client(1, "mario", "mario@email.com"));
		clientList.add(new Client(3, "pedro", "pedro@email.com"));
		clientList.add(new Client(4, "joao", "joao@email.com"));
		clientList.add(new Client(5, "maria", "maria@email.com"));
		
	}

	public List<Client> getAll(){
		return clientList;
	}

	public Client getById(int id) {
		for(Client client : clientList) {
			if(client.getId() == id) {
				return client;
			}
		}
		return null;
	}

	public Client createClient(Client client) {
		clientList.add(client);		
		return client;
	}

	public Client updateClient(int id, Client cliente) {
		for(Client client : clientList) {
			if(client.getId() == id) {
				client.setEmail(cliente.getEmail());
				client.setNome(cliente.getNome());				
			}
		}
		return null;
	}

	public void removeClient(Client client) {
		clientList.remove(client);		
	}

	
}
