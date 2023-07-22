package com.example.demoerrorthymleaf;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class HomeController {
    PersonService personService;

    @GetMapping("/")
    public String showAllPersons(Model model) {
        model.addAttribute("persons", personService.getAll());
        return "index";
    }

    @GetMapping("/add")
    public String showAddPersonForm(Model model) {
        model.addAttribute("person", Person.builder().build());
        return "add-person";
    }

    @PostMapping("/add")
    public String addPerson(@Valid Person person, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-person";
        }
        personService.save(person);
        return "redirect:/";
    }

}
