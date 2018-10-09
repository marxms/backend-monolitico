package br.com.reserveja.model.endereco;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import br.com.reserveja.model.pessoa.Pessoa;

@Entity
public class Endereco implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6468282937915501280L;

	@Id
	@GenericGenerator(name="enderecoIncrement" , strategy="increment")
	@GeneratedValue(generator="enderecoIncrement")
	private Long id;
	
	private String logradouro;
	
	private String cidade;
	
	private String estado;
	
	private String cep;
	
	private Integer numero;
	
	private String complemento;
	
	@OneToMany(targetEntity = Pessoa.class, cascade=CascadeType.DETACH, mappedBy="endereco")
	private List<Pessoa> pessoas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
}
