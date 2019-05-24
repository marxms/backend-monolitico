package br.com.reserveja.service.pessoa;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.reserveja.dao.GenericDao;
import br.com.reserveja.dao.PessoaDAOImpl;
import br.com.reserveja.exception.CustomException;
import br.com.reserveja.model.domain.pessoa.Pessoa;
import br.com.reserveja.model.representation.user.UserDataDTO;
import br.com.reserveja.model.representation.user.UserResponseDTO;
import br.com.reserveja.resource.UserController;
import br.com.reserveja.service.AbstractService;

@Service
public class PessoaServiceImpl extends AbstractService<Pessoa>{

	final String uri = "http://localhost:8080/users/me";
	final String uriUpdateUser = "http://localhost:8080/updateUser";
	   	   
	@Autowired
	PessoaDAOImpl pessoaDAO;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	UserController userController;
	
	@Override
	public GenericDao<Pessoa, Serializable> getDao() {
		return pessoaDAO;
	}
	
	@Override
	public Pessoa insert(Pessoa t) {
		return pessoaDAO.cadastrarPessoa(t);
	}
	
	@Override
	public Pessoa list(Long id) {
		return super.list(id);
	}
	
	public UserResponseDTO obtemUsuarioLogado(String token) {
		UserResponseDTO result = userController.whoami(token);
		result.setPessoa(null);
	    return result;
	    
	}
	
	public UserResponseDTO atualizaPessoaUser(UserDataDTO user, String token) {
		try {
			userController.updateUser(user.getUsername(), user);
			return obtemUsuarioLogado(token);
		} catch (Exception e) {
			 throw new CustomException("Erro ao atualizar pessoa na tb_user", HttpStatus.INTERNAL_SERVER_ERROR);
		}				  
				  
	}
	
}
