package curso.cas.microservicios.ProyectoVideoClub;

import java.io.PrintStream;

import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import curso.cas.microservicios.ProyectoVideoClub.controller.WebController;
import curso.cas.microservicios.ProyectoVideoClub.servlet.HolaServlet;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@Configuration
public class ProyectoVideoClubApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(ProyectoVideoClubApplication.class);

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ProyectoVideoClubApplication.class);
		// app.setBannerMode(Banner.Mode.CONSOLE);
		app.run(args);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("curso.cas.microservicios.ProyectoVideoClub.controller"))
				.paths(PathSelectors.regex("/.*")).build().apiInfo(apiEndPointsInfo());
	}

	private ApiInfo apiEndPointsInfo() {
		return new ApiInfoBuilder().title("Spring Boot REST API").description("VideoClub Management REST API")
				.contact(new Contact("David Robledo", "www.davidrobledo.es", "correo@davidrobledo.es"))
				.license("Apache 2.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html").version("1.0.0")
				.build();
	}

	@Bean
	public ServletRegistrationBean<HttpServlet> holaServlet() {
		ServletRegistrationBean<HttpServlet> retorno = new ServletRegistrationBean<HttpServlet>();
		retorno.setServlet(new HolaServlet());
		retorno.addUrlMappings("/hola/*");
		retorno.setLoadOnStartup(1);
		return retorno;
	}

	@Autowired
	MiAppProperties props;

	@Override
	public void run(String... args) throws Exception {
		
		log.info("Descripcion aplicacion " + props.getDescripcion());
		log.info("Nombre aplicacion " + props.getNombre());
		log.info("Servidor aplicacion " + props.getServidor());
		
	}

	@Component
	@ConfigurationProperties(prefix = "miapp")
	public static class MiAppProperties {
		private String servidor;
		private String nombre;
		private String descripcion;

		public String getServidor() {
			return servidor;
		}

		public void setServidor(String servidor) {
			this.servidor = servidor;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

	}

}
