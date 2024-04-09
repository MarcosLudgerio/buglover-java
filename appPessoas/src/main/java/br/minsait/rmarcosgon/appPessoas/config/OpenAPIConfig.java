package br.minsait.rmarcosgon.appPessoas.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Contact;

import java.util.List;

@Configuration
public class OpenAPIConfig {

    @Value("${minsait.rmarcos.test-url}")
    private String testUrl;

    @Bean
    public OpenAPI myOpenAPI() {
        Server server = new Server();
        server.setUrl(testUrl);
        server.setDescription("Server URL in Localhost");

        Contact contact = new Contact();
        contact.setEmail("rmarcosgon@minsait.com");
        contact.setName("Marcos Ludgério");
        contact.setUrl("https://github.com/marcosludgerio/");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("API App Pessoas")
                .version("1.0")
                .contact(contact)
                .description("API para cadatros de pessoas")
                .license(mitLicense);
        return new OpenAPI().info(info).servers(List.of(server));
    }
}
