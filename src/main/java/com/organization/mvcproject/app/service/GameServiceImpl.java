package com.organization.mvcproject.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.mvcproject.app.api.service.GameService;
import com.organization.mvcproject.app.mockdao.MockGameDAO;
import com.organization.mvcproject.app.api.model.Game;

@Service("javaGameService")
public class GameServiceImpl implements GameService {
	
//Create, Read, Update, Delete
@Autowired
private MockGameDAO mockDAO; 
	

	@Override
	public List<Game> retrieveAllGames() {
		
		return mockDAO.retrieveAllGames();
	}

	@Override
	public Game saveGame(Game game) {
		return mockDAO.saveGame(game);
	}

	@Override
	public Boolean deleteGame(Long id) {
		
		return mockDAO.deleteGame(id);
	}
	@Override
	public Game updateGame(Game game) {
		
		return mockDAO.updateGame(game);
	}

	@Override
	public List<Game> retrieveAllGamesByGenre() {
	
		return mockDAO.updateGame(game);
	}	

}