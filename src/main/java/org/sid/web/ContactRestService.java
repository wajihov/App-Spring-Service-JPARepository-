package org.sid.web;

import java.util.List;

import org.sid.dao.ContactRepository;
import org.sid.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactRestService {

	@Autowired
	private ContactRepository contactRepository;

	@GetMapping("/clients")
	public List<Client> getClients() {
		return contactRepository.findAll();
	}

	@GetMapping("/clients/{id}")
	public Client getClient(@PathVariable Long id) {
		return contactRepository.findOne(id);
	}

	@PostMapping("/clients")
	public Client saveClients(@RequestBody Client client) {
		return contactRepository.save(client);
	}

	@DeleteMapping("/clients/{id}")
	public boolean deleteClient(@PathVariable Long id) {
		contactRepository.delete(id);
		return true;
	}

	@PutMapping("/clients/{id}")
	public Client updateClient(@PathVariable Long id, @RequestBody Client client) {
		client.setId(id);
		return contactRepository.save(client);
	}

	// @GetMapping("/chercherClients")
	@RequestMapping(value = "/chercheClient", method = RequestMethod.GET)
	public Page<Client> chercherClients(@RequestParam(name = "mc", defaultValue = "") String mc,
			@RequestParam(name = "page", defaultValue = "0") int p,
			@RequestParam(name = "size", defaultValue = "5") int s) {
		return contactRepository.chercherClient("%" + mc + "%", new PageRequest(p, s));
	}
}