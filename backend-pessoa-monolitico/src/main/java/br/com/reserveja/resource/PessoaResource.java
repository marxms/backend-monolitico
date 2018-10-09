package br.com.reserveja.resource;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.reserveja.model.pessoa.Pessoa;
import br.com.reserveja.model.user.User;
import br.com.reserveja.representation.PessoaRepresentation;
import br.com.reserveja.representation.UserDataDTO;
import br.com.reserveja.representation.UserResponseDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import br.com.reserveja.service.pessoa.PessoaServiceImpl;
@CrossOrigin(allowCredentials="true")
@RestController
@RequestMapping("/pessoa")
@Api(tags = "pessoas")
public class PessoaResource {

	private ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	private PessoaServiceImpl pessoaService;
	
	@Autowired
	private UserController userController;
	
	
	@PostMapping("/register")
	@ApiOperation(value="${PessoaResource.cadastrarPessoa}")
	public PessoaRepresentation cadastrarPessoa(
			@ApiParam("Pessoa Cadastro")
			@RequestBody PessoaRepresentation pessoa, @RequestHeader(value="Authorization") String token){
		Pessoa pessoaRetorno = null;
		User usuarioRetorno = null;
		pessoaRetorno = modelMapper.map(pessoa, Pessoa.class);
		UserResponseDTO usuarioLogado = this.resolveToken(token);
		usuarioRetorno = modelMapper.map(usuarioLogado, User.class);
		pessoaRetorno.setUser(usuarioRetorno);
		pessoaRetorno = pessoaService.insert(modelMapper.map(pessoa, Pessoa.class));
		usuarioRetorno.setPessoa(pessoaRetorno);
		UserDataDTO request = modelMapper.map(usuarioRetorno, UserDataDTO.class);
		request.getPessoa().setUser(null);
		/* CHAMADA AO SERVIÇO DE ATUALIZAÇÃO DE PESSOA NO AUTH SERVICE */
		//usuarioLogado = pessoaService.atualizaPessoaUser(request, token);		
		usuarioLogado = userController.updateUser(usuarioRetorno.getUsername(), request);
		PessoaRepresentation pesRepresentation = modelMapper.map(pessoaRetorno, PessoaRepresentation.class);
		return pesRepresentation;
	}
	
	private UserResponseDTO resolveToken(String token) {
		UserResponseDTO response = null;
		response = pessoaService.obtemUsuarioLogado(token);
		
		return response;
	}
}
