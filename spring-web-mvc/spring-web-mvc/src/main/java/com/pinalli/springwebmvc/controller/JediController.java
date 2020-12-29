package com.pinalli.springwebmvc.controller;

import com.pinalli.springwebmvc.model.Jedi;
import com.pinalli.springwebmvc.repositoryJedi.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class JediController {

    @Autowired
    private JediRepository repository;

    @GetMapping("/jedi")
    public ModelAndView Jedi(){

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("jedi");

        modelAndView.addObject("allJedi",repository.getAllJedi());

        return modelAndView;
    }

    @GetMapping("/new-jedi")
    public ModelAndView newJedi(){

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("new-jedi");

        modelAndView.addObject("jedi", new Jedi());

        return modelAndView;

    }

    @PostMapping("/jedi")
    public String creatJedi(@Validated @ModelAttribute Jedi jedi,  BindingResult result,
    RedirectAttributes redirectAttributes){

        if (result.hasErrors()){
            return  "new jedi";
        }
        repository.add(jedi);
        redirectAttributes.addFlashAttribute("message", "Jedi cadastrado com sucesso");
        return "redirect:jedi";
    }

}
