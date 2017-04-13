package br.com.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.demo.modal.ClienteDTO;
import br.com.demo.modal.ProdutoDTO;

@RestController
public class ClienteController {

	@Autowired
	private RestTemplate restTemplate;
	
	@CrossOrigin
	@RequestMapping(value="/api/v1/clientes", produces=MediaType.APPLICATION_JSON_UTF8_VALUE, method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<ClienteDTO>> obterListaClientes() {
		List<ClienteDTO> clientes = new ArrayList<>();
		ClienteDTO cliente = new ClienteDTO();
		cliente.setId(1l);
		cliente.setNome("Josivaldo Mendes");
		cliente.setEmail("josivaldo.mendes@mail.com");
		cliente.setDtNascimento(Calendar.getInstance().getTime());
		clientes.add(cliente );
		return ResponseEntity.ok().body(clientes);
	}
	
	@CrossOrigin
	@RequestMapping(value="/api/v1/clientes/{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE, method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<Map<String, Object>> obterCliente(@PathParam("id") Long id) {
		ClienteDTO cliente = new ClienteDTO();
		cliente.setId(1l);
		cliente.setNome("Josivaldo Mendes");
		cliente.setEmail("josivaldo.mendes@mail.com");
		cliente.setDtNascimento(Calendar.getInstance().getTime());
		
		String produtoURI = "http://produto-api/api/v1/produtos";
		
		ResponseEntity<ProdutoDTO[]> response = restTemplate.getForEntity(produtoURI, ProdutoDTO[].class);
		
		Map<String, Object> map = new HashMap<>();
		map.put("cliente", cliente);
		map.put("produtos", Arrays.asList(response.getBody()));
		
		return ResponseEntity.ok().body(map);
	}
}
