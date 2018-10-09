package br.com.reserveja.service.pessoa;

import java.io.IOException;
import java.io.Serializable;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.reserveja.dao.GenericDao;
import br.com.reserveja.dao.PessoaDAOImpl;
import br.com.reserveja.model.pessoa.Pessoa;
import br.com.reserveja.representation.UserDataDTO;
import br.com.reserveja.representation.UserResponseDTO;
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
	    return result;
	    
	}
	
	public UserResponseDTO atualizaPessoaUser(UserDataDTO user, String token) {
				  try {
				String body = null;
				ObjectMapper mapper = new ObjectMapper();
				body = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
		        // Find room ID based on name
		       // String roomId = getRoomID(WEBSERVICE_URL, AUTHTOKEN, roomName);
				StringEntity entity = new StringEntity(body, ContentType.APPLICATION_JSON);
		        CloseableHttpClient http = HttpClientBuilder.create().build();
		        HttpPatch updateRequest = new HttpPatch("http://localhost:8080/users/updateUser/"+user.getUsername());
		        updateRequest.setEntity(entity);
		        updateRequest.setHeader("Authorization", token);
		        

		        HttpResponse response = http.execute(updateRequest);
		        if (response.getStatusLine().getStatusCode() == 200) {
		        	return obtemUsuarioLogado(token);
		        } else {
		        	throw new IOException("Status nao esperado");
		        }
		        
		        
		    } catch (IOException e) {
		    	return null;
		    }
	}
	
}
