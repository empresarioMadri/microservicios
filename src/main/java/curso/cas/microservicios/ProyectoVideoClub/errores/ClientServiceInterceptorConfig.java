package curso.cas.microservicios.ProyectoVideoClub.errores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class ClientServiceInterceptorConfig extends WebMvcConfigurerAdapter{
	
	@Autowired
	ClientInterceptor clientInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(clientInterceptor);
	}

}
