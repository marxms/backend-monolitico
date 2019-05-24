package br.com.reserveja.model.representation.telefone;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import br.com.reserveja.model.domain.pessoa.Pessoa;

public class TelefoneRepresentation{
	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("ddd")
	private Integer DDD;
	
	@JsonProperty("numero")
	private Integer numero;
	
	@JsonProperty("tp_telefone")
	private String tp_telefone;
	
	@JsonProperty(access=Access.WRITE_ONLY, value="pessoa")
	private Pessoa pessoa;


	public void setId(Long id) {
		this.id = id;
	}

	public Integer getDDD() {
		return DDD;
	}

	public void setDDD(Integer dDD) {
		DDD = dDD;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTp_telefone() {
		return tp_telefone;
	}

	public void setTp_telefone(String tp_telefone) {
		this.tp_telefone = tp_telefone;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Long getId() {
		return id;
	}

}
