package com.ciclic.duff.controller;

import com.ciclic.duff.domain.Beer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@Controller
@RequestMapping({"/", "/home"})
public class DuffController {

    private static final Logger LOGGER = Logger.getLogger(DuffController.class.getName());

    @GetMapping("/duffs")
    public String index() {
        return "index";
    }

    @PostMapping("/duffs/new")
    public String save(Model model, @ModelAttribute("beer") Beer beer) {
        LOGGER.info("Save ");
        return "save";
    }

    @PutMapping("/duffs/update")
    public String update(Model model, @ModelAttribute("beer") Beer beer) {
        LOGGER.info("Update ");
        return "update";
    }

    @GetMapping("/duffs/get")
    public String get(Model model, @ModelAttribute("beer") Beer beer) {
        LOGGER.info("Get ");
        return "get";
    }

    @GetMapping("/duffs/delete")
    public String delete(Model model, @ModelAttribute("beer") Beer beer) {
        LOGGER.info("Delete ");
        return "delete";
    }

}