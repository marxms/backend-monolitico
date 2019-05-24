package br.com.reserveja.service.telefone;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.reserveja.dao.GenericDao;
import br.com.reserveja.dao.TelefoneDAOImpl;
import br.com.reserveja.model.domain.telefone.Telefone;
import br.com.reserveja.service.AbstractService;

@Service
public class TelefoneServiceImpl extends AbstractService<Telefone>{

	@Autowired
	TelefoneDAOImpl telefoneDAO;
	
	@Override
	public GenericDao<Telefone, Serializable> getDao() {
		// TODO Auto-generated method stub
		return telefoneDAO;
	}
	
	@Override
	public Telefone insert(Telefone t) {
		// TODO Auto-generated method stub
		return super.insert(t);
	}
	
	@Override
	public Telefone list(Long id) {
		// TODO Auto-generated method stub
		return super.list(id);
	}
	
}
