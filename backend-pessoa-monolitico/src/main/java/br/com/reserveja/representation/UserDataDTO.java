package br.com.reserveja.representation;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.reserveja.model.user.Role;
import io.swagger.annotations.ApiModelProperty;

public class UserDataDTO {

	@ApiModelProperty(position = 2)
	@JsonProperty("username")
	private String username;
	@ApiModelProperty(position = 3)
	@JsonProperty("password")
	private String password;
	@JsonProperty("email")
	@ApiModelProperty(position = 4)
	private String email;
	@JsonProperty(value= "pessoa")
	@ApiModelProperty(position = 5)
	private PessoaRepresentation pessoa;
	
	private List<Role> roles;

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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public PessoaRepresentation getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaRepresentation pessoa) {
		this.pessoa = pessoa;
	}

}
