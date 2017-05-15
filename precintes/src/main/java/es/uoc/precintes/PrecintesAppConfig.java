package es.uoc.precintes;

import org.springframework.context.annotation.Configuration;

/**
 * clase que defineix la configuració de l'aplicació
 * @author BERNAT1
 *
 */

@Configuration
public class PrecintesAppConfig {
	
	// configura les pagines d'error https://www.sporcic.org/2014/05/custom-error-pages-with-spring-boot/
	// eLIMINAT JA QUE sPRING bOOT ES CAPAÇ DE resoltre els errors si es posen els recursos estatics a una carpeta errors/4xxx.html 
//	@Bean
//	public EmbeddedServletContainerCustomizer containerCustomizer() {
//	 
//	   return (container -> {
//	        ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/401.html");
//	        ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
//	        ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html");
//	 
//	        container.addErrorPages(error401Page, error404Page, error500Page);
//	   });
//	}
	
//	/* configura el locale Catala */
//	
//	@Bean
//    public LocaleResolver localeResolver() {
//        SessionLocaleResolver slr = new SessionLocaleResolver();
//        Locale locale=new Locale("ca", "ES");
//        slr.setDefaultLocale(locale);
//        return slr;
//    }
// 
 
   
    
}
