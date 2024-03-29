package com.holik.simpeg.server;

//import com.holik.simpeg.share.entity.Book;
//import com.holik.simpeg.server.resource.MyJaxRsResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EntityScan({"com.holik.simpeg.shared.entity"})
public class ServerApplication {

    
  
    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }
    
    
    /*
    @Profile("demo")
    @Bean
    CommandLineRunner initDatabase(BookRepository repository) {
        return args -> {
            repository.save(new Book("A Guide to the Bodhisattva Way of Life", "Santideva", new BigDecimal("15.41")));
            repository.save(new Book("The Life-Changing Magic of Tidying Up", "Marie Kondo", new BigDecimal("9.69")));
            repository.save(new Book("Refactoring: Improving the Design of Existing Code", "Martin Fowler", new BigDecimal("47.99")));
        };
    }
    */
       
}
