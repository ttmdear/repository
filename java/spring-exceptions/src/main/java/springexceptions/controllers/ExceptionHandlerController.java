package springexceptions.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import springexceptions.exceptions.NotFound;
import springexceptions.exceptions.PermissionDenied;

@ControllerAdvice
public class ExceptionHandlerController {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFound.class)
    public ModelAndView handleNotFound() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("notFound");

        return modelAndView;
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(PermissionDenied.class)
    public ModelAndView handlePermissionDenied() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("permissionDenied");

        return modelAndView;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NumberFormatException.class)
    public ModelAndView handleNumberFormatException(Exception exception) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("400error");
        modelAndView.addObject("exception", exception);

        return modelAndView;
    }
}
