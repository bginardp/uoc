package es.uoc.precintes;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * clase que defineix la configuració de l'aplicació
 * @author BERNAT1
 *
 */

@Configuration

public class PrecintesAppConfig {
	
	/* configura el locale Catala */
	
	@Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        Locale locale=new Locale("ca", "ES");
        slr.setDefaultLocale(locale);
        return slr;
    }
 
 
   
    
}
