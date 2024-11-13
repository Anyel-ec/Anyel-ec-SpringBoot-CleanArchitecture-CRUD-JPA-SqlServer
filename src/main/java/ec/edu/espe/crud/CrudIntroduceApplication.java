package ec.edu.espe.crud;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudIntroduceApplication {

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure().load();

        // Set environment variables as system properties so Spring can access them
        System.setProperty("USERNAME_MSSQL", dotenv.get("USERNAME_MSSQL", ""));
        System.setProperty("PASSWORD_MSSQL", dotenv.get("PASSWORD_MSSQL", ""));

        SpringApplication.run(CrudIntroduceApplication.class, args);
    }

}
