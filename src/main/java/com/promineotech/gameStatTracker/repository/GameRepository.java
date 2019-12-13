package com.promineotech.gameStatTracker.repository;

import com.promineotech.gameStatTracker.entity.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Long> {}
