package com.organization.mvcproject.app.model;

import java.util.Collection;

import org.springframework.stereotype.Component;


import com.organization.mvcproject.app.api.model.Game;

@Component
public class GameImpl implements Game{

	private Long id;
	private String name;
	private String genre;

	public Long getId() {
		return id;
	}

	public void setId(Long gameId) {
		this.id = gameId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

}
