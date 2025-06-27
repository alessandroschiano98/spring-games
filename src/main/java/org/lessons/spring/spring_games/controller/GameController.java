package org.lessons.spring.spring_games.controller;


import org.lessons.spring.spring_games.model.Game;
import org.lessons.spring.spring_games.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

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

    @GetMapping("/{id}")
    public String show(@PathVariable(name = "id") Integer id, Model model) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Game not found with id: " + id));
        ;
        model.addAttribute("game", game);
        return "games/show";
    }

    // ! CREATE
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("game", new Game());
        return "games/create";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("game") Game formGame, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "games/create";
        }

        gameRepository.save(formGame);
        return "redirect:/games";
    }

    // ! EDIT
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Game not found"));
        model.addAttribute("game", game);
        return "games/edit";
    }

    // ! UPDATE

    @PostMapping("/edit/{id}")
    public String update(@PathVariable("id") Integer id,
            @Valid @ModelAttribute("game") Game formGame,
            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "games/edit";
        }

        formGame.setId(id);
        gameRepository.save(formGame);
        return "redirect:/games/" + id;
    }

    // ! DELETE
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") Integer id, Model model) {
        gameRepository.deleteById(id);
        return "redirect:/games";
    }

}
