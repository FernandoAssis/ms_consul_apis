package br.com.demo.modal;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	@JsonProperty ("data-nascimento")
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dtNascimento;
	private String email;

}
