package com.promineotech.gameStatTracker.repository;

import com.promineotech.gameStatTracker.entity.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Long> {}
