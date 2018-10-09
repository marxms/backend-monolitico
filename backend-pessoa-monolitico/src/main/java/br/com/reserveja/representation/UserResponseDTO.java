package br.com.reserveja.representation;

import java.util.List;

import br.com.reserveja.model.user.Role;
import io.swagger.annotations.ApiModelProperty;

public class UserResponseDTO {

	@ApiModelProperty(position = 0)
	private Integer id;
	@ApiModelProperty(position = 1)
	private String username;
	@ApiModelProperty(position = 2)
	private String email;
	@ApiModelProperty(position = 3)
	List<Role> roles;
	@ApiModelProperty(position = 4)
	private String token;
	@ApiModelProperty(position = 5)
	private PessoaRepresentation pessoa;

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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public PessoaRepresentation getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaRepresentation pessoa) {
		this.pessoa = pessoa;
	}

}
