package org.lessons.spring.spring_games.controller;

import org.lessons.spring.spring_games.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("games", gameRepository.findAll());
        return "games/index";
    }

}
