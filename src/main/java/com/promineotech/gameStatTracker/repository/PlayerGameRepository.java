package com.promineotech.gameStatTracker.repository;

import com.promineotech.gameStatTracker.entity.PlayerGame;
import org.springframework.data.repository.CrudRepository;

public interface PlayerGameRepository extends CrudRepository<PlayerGame, Long> {}
