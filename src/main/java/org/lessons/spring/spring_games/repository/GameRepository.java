package org.lessons.spring.spring_games.repository;

import org.lessons.spring.spring_games.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

}
