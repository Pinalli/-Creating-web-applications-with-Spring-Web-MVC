package com.pinalli.springwebmvc.controller;

import com.pinalli.springwebmvc.model.Jedi;
import com.pinalli.springwebmvc.repositoryJedi.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

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

    @GetMapping("/search")
    public ModelAndView search(@RequestParam(value = "name") final String name) {

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("jedi");

        modelAndView.addObject("allJedi", repository.findByNameContainingIgnoreCase(name));

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
        repository.save(jedi);
        redirectAttributes.addFlashAttribute("message", "Jedi cadastrado com sucesso");
        return "redirect:jedi";
    }

    @GetMapping("/jedi/{id}/delete")
    public String deleteJedi(@PathVariable("id") final Long id, RedirectAttributes redirectAttributes) {

        final Optional<Jedi> jedi = repository.findById(id);

        repository.delete(jedi.get());

        redirectAttributes.addFlashAttribute("message", "Jedi removido com sucesso.");

        return "redirect:/jedi" ;
    }

    @GetMapping("/jedi/{id}/update")
    public String updateJedi(@PathVariable("id") final Long id, Model model) {

        final Optional<Jedi> jedi = repository.findById(id);

        model.addAttribute("jedi", jedi.get());

        return "edit-jedi";
    }
}
