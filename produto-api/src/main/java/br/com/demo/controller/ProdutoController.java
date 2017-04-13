package br.com.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.demo.modal.ProdutoDTO;

@RestController
public class ProdutoController {

	@CrossOrigin
	@RequestMapping (value="/api/v1/produtos", produces=MediaType.APPLICATION_JSON_UTF8_VALUE, method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<ProdutoDTO>> getProdutos() {
		return ResponseEntity.ok().body(Arrays.asList(
				new ProdutoDTO(1l, "Produto 01", "Produto 01"), 
				new ProdutoDTO(2l, "Produto 02", "Produto 02"),
				new ProdutoDTO(3l, "Produto 03", "Produto 03"),
				new ProdutoDTO(4l, "Produto 04", "Produto 04"),
				new ProdutoDTO(5l, "Produto 05", "Produto 05")));
	}
}
