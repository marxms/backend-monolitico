package br.com.reserveja.service.endereco;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.reserveja.dao.EnderecoDAOImpl;
import br.com.reserveja.dao.GenericDao;
import br.com.reserveja.model.domain.endereco.Endereco;
import br.com.reserveja.service.AbstractService;

@Service
public class EnderecoServiceImpl extends AbstractService<Endereco>{

	@Autowired
	EnderecoDAOImpl enderecoDAO;
	
	@Override
	public GenericDao<Endereco, Serializable> getDao() {
		return enderecoDAO;
	}
	
	@Override
	public Endereco insert(Endereco t) {
		return super.insert(t);
	}
	
	@Override
	public Endereco list(Long id) {
		return super.list(id);
	}
	
}
