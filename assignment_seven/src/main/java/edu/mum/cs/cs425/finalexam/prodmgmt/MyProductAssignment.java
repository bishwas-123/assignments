package edu.mum.cs.cs425.finalexam.prodmgmt;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.mum.cs.cs425.finalexam.prodmgmt.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import edu.mum.cs.cs425.finalexam.prodmgmt.model.Product;

@SpringBootApplication
public class MyProductAssignment implements CommandLineRunner {
	
	@Autowired
	private LocalContainerEntityManagerFactoryBean factory;

	@Autowired
	private IRepository productRepository;
	public static void main(String[] args) {		
		SpringApplication.run(MyProductAssignment.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println( "MY console app started " );
		Product p = new Product(1003L, "IPhone max x", 2500.0f, LocalDate.of(2017, 10, 31));
		saveProduct(p);

		ObjectMapper mapper = new ObjectMapper();
		try {
			String json = mapper.writeValueAsString(p);
			System.out.println("JSON data = " + json);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
//		for(Product product:productRepository.findAll()){
//
//
//		}


        System.out.printf( "Saved Product: productId:%d, name:%s, unitPrice:%.2f, dateMfd:%s }\n",
        		p.getProductId(), p.getName(), p.getUnitPrice(), p.getDateMfd());
	}
	
    private void saveProduct(Product p) {
    	if (p != null) {
	        EntityManager em = factory.getObject().createEntityManager();
	        em.getTransaction().begin();
	        em.persist(p);
	        em.getTransaction().commit();
	        em.close();
    	}
    }
}
