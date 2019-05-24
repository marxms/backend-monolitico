package br.com.reserveja.model.representation.user;

import java.util.List;

import br.com.reserveja.model.domain.user.Role;
import br.com.reserveja.model.representation.pessoa.PessoaRepresentation;
import io.swagger.annotations.ApiModelProperty;

public class UserDataDTO {

	@ApiModelProperty(position = 0)
	private String username;
	@ApiModelProperty(position = 1)
	private String password;
	@ApiModelProperty(position = 2)
	private String email;
	@ApiModelProperty(position = 3)
	List<Role> roles;
	@ApiModelProperty(position = 4)
	private PessoaRepresentation pessoa;

	public PessoaRepresentation getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaRepresentation pessoa) {
		this.pessoa = pessoa;
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

}
