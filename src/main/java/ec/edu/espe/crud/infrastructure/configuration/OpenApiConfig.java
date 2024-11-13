package ec.edu.espe.crud.infrastructure.configuration;
/*
 * Author: Anyel EC
 * Github: https://github.com/Anyel-ec
 * Creation date: 13/11/2024
 */

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;
@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Clean Architecture",
                version = "1.0",
                contact = @Contact(name = "Developed by Angel Patiño", email = "appatino@espe.edu.ec", url = "www.anyel.top")),
        servers = @Server(url = "http://localhost:8080")
)
public class OpenApiConfig {
}