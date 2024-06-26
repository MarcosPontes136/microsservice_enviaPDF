package com.microsservice_enviarPDF;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class MicrosserviceEnviarPdfApplication {
	
    private static final String URL_APP = "url.aplicacao";
    private static final String SERVER_PORT = "server.port";
    private static final Logger LOGGER = LoggerFactory.getLogger(MicrosserviceEnviarPdfApplication.class);

	public static void main(String[] args) {
		final ConfigurableApplicationContext ctx =  SpringApplication.run(MicrosserviceEnviarPdfApplication.class, args);
        try {
            final Environment env = ctx.getEnvironment();
            LOGGER.info("""
                            
                             **********************\s
                            	Aplicacao {} iniciada com sucesso!
                            	Disponivel nos enderecos:
                            	Local: http://localhost:{}
                            	Externo: {}
                            	Swagger Url: {}
                            	Local Swagger Url: http://localhost:{}
                            """,
                    env.getProperty("spring.application.name"),
                    env.getProperty(SERVER_PORT),
                    env.getProperty(URL_APP),
                    env.getProperty(URL_APP) /*+ SWAGGER_UI_HTML*/,
                    env.getProperty(SERVER_PORT) /*+ SWAGGER_UI_HTML*/);
        } catch (final Exception e) {
            LOGGER.error("Falha ao executar aplicacao: {}", e); 
            ctx.close();
        }
	}

}
