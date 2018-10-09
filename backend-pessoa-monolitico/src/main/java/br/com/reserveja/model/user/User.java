package br.com.reserveja.model.user;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import br.com.reserveja.model.pessoa.Pessoa;

@Entity
public class User implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 6889188451159419338L;

	@Id
	@GenericGenerator(name="userIncrement" , strategy="increment")
	@GeneratedValue(generator="userIncrement")
	private Integer id;

	@Size(min = 4, max = 255, message = "Minimum username length: 4 characters")
	@Column(nullable = false)
	private String username;

	@Column(nullable = false)
	private String email;

	@Size(min = 8, message = "Minimum password length: 8 characters")
	private String password;
	
	@OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.DETACH, optional=true)
	@JoinColumn(name="pessoa_id")
	private Pessoa pessoa;

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		 this.pessoa = pessoa;
		 }

	@ElementCollection(fetch = FetchType.EAGER)
	List<Role> roles;
	
	String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
