package springexceptions.controllers;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import springexceptions.exceptions.NotFound;
import springexceptions.exceptions.PermissionDenied;

public class BaseController {
    @ExceptionHandler(NotFound.class)
    public ModelAndView handleNotFound() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("notFound");

        return modelAndView;
    }

    @ExceptionHandler(PermissionDenied.class)
    public ModelAndView handlePermissionDenied() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("permissionDenied");

        return modelAndView;
    }
}
