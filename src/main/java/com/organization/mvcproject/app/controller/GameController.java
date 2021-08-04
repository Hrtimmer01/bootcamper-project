package com.organization.mvcproject.app.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.organization.mvcproject.app.api.model.Game;
import com.organization.mvcproject.app.model.GameImpl;
import com.organization.mvcproject.app.model.ReviewImpl;
import com.organization.mvcproject.app.api.service.GameService;

@Controller
@RestController
public class GameController {

	@Autowired
	private GameService gameService;



	@RequestMapping(value = "/games", method = RequestMethod.GET)
	public ModelAndView game() {
		return new ModelAndView("games", "command", new GameImpl());
	}

	@GetMapping(value = "games/getAll")
	public ResponseEntity<List<Game>> fetchAllGames() {
		return new ResponseEntity<List<Game>>(gameService.retrieveAllGames(), HttpStatus.OK);
	}
	@GetMapping(value = "games/getAllByGenre")
	public ResponseEntity<List<Game>> fetchAllGamesByGenre() {
		return new ResponseEntity<List<Game>>(gameService.retrieveAllGamesByGenre(), HttpStatus.OK);
	}

	@PostMapping(value = "games/createGame", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createGame(@RequestBody GameImpl game) {
		gameService.saveGame(game);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	@PutMapping(value = "games/updateGame", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updateGame(@RequestBody GameImpl game) {
		gameService.updateGame(game);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@DeleteMapping(value = "games/{id}")
	public ResponseEntity<?> deleteGame(@PathVariable("id") Long id) {
		Boolean isDeleted = gameService.deleteGame(id);
		
		if(Boolean.valueOf(isDeleted)) {
			return new ResponseEntity<>( HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
	}
}