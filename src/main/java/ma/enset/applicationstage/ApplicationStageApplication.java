package ma.enset.applicationstage;

import ma.enset.applicationstage.service.IUserInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;

@SpringBootApplication
public class ApplicationStageApplication implements CommandLineRunner {

    @Autowired
    private IUserInitService userInitService;


    public static void main(String[] args) {
        SpringApplication.run(ApplicationStageApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


    }

}
