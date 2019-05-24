package br.com.reserveja;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@EnableAutoConfiguration
@EnableJpaRepositories(basePackages={"br.com.reserveja.dao"}, transactionManagerRef ="transactionManager",entityManagerFactoryRef="sessionFactory")
@SpringBootApplication
public class BackendPessoaMonoliticoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendPessoaMonoliticoApplication.class, args);
	}
	
	
	@Bean
	@Qualifier(value = "restTemplate")
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean
	@Qualifier(value = "entityManager")
	public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
	    return entityManagerFactory.createEntityManager();
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}


}
