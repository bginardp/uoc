package es.uoc.precintes.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
/**
 * gestiona els error de forma global
 * @author BERNAT1
 *
 */
@ControllerAdvice
public class ErrorController {

	public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = {Exception.class, RuntimeException.class})
    public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e) {
            ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW);
        mav.addObject("timestamp", new Date());
        mav.addObject("title", "S'ha produit un error");
        mav.addObject("error", e);
        mav.addObject("message", "Aviseu a l'administrador de l'aplicació");
        mav.addObject("url", "La url que ha provocat aquesta situació ha sigut "+request.getRequestURL());
        return mav;
    }
}