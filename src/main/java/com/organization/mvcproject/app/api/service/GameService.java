package com.organization.mvcproject.app.api.service;


import java.util.List;

import com.organization.mvcproject.app.api.model.Game;
import com.organization.mvcproject.app.model.GameImpl;

public interface GameService {

	List<Game> retrieveAllGames();

	Game saveGame(Game game);
	

	Boolean deleteGame(Long id);

	Game updateGame(Game game);

	List<Game> retrieveAllGamesByGenre();


}
