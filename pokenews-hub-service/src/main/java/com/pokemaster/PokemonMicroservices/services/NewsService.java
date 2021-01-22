package com.pokemaster.PokemonMicroservices.services;

import java.util.List;

import com.pokemaster.PokemonMicroservices.models.NewsFeed;

public interface NewsService {
	
	public List<NewsFeed> getAllNewsArticles();
	
	public List<NewsFeed> saveNewsArticles(List<NewsFeed> nList);
	
	public NewsFeed getNewsArticleById(int id);
}
