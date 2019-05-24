package br.com.reserveja.model.domain.telefone;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;

import br.com.reserveja.model.domain.pessoa.Pessoa;

@Entity
@Table
@TypeDef(
	    name = "pgsql_enum",
	    typeClass = PostgreSQLEnumType.class
	)
public class Telefone implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4780100453337281778L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private Integer DDD;
	
	private Integer numero;
	
	@Enumerated(EnumType.STRING)
    @Type( type = "pgsql_enum" )
	private EnumTipoTelefone tp_telefone;
	
	@ManyToOne
	private Pessoa pessoa;
	
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

	public EnumTipoTelefone getTp_telefone() {
		return tp_telefone;
	}

	public void setTp_telefone(EnumTipoTelefone tp_telefone) {
		this.tp_telefone = tp_telefone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	
	
}
