package br.com.reserveja.service.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.reserveja.dao.UserRepository;
import br.com.reserveja.exception.CustomException;
import br.com.reserveja.model.user.User;
import br.com.reserveja.security.JwtTokenProvider;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private JwtTokenProvider jwtTokenProvider;

  @Autowired
  private AuthenticationManager authenticationManager;

  public User signin(String username, String password) {
    try {
    	User retorno = search(username);
    	authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    	retorno.setToken(jwtTokenProvider.createToken(username, userRepository.findByUsername(username).getRoles()));
      return retorno;
    } catch (AuthenticationException e) {
      throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
    }
  }

  public String signup(User user) {
    if (!userRepository.existsByUsername(user.getUsername())) {
      user.setPassword(passwordEncoder.encode(user.getPassword()));
      userRepository.save(user);
      return jwtTokenProvider.createToken(user.getUsername(), user.getRoles());
    } else {
      throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
    }
  }

  public void delete(String username) {
    userRepository.deleteByUsername(username);
  }

  public User search(String username) {
    User user = userRepository.findByUsername(username);
    if (user == null) {
      throw new CustomException("The user doesn't exist", HttpStatus.NOT_FOUND);
    } 
    return user;
  }
  
  public User updatePessoa(User user) {
	    user = userRepository.save(user);
	    if (user == null) {
	      throw new CustomException("The user doesn't exist", HttpStatus.NOT_FOUND);
	    }
	    return user;
	  }
  
  public User whoami(HttpServletRequest req) {
	    return userRepository.findByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req)));
	  }
  
  public User whoami(String req) {
    return userRepository.findByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req)));
  }

}