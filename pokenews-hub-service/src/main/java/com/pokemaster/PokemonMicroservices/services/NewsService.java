package com.pokemaster.PokemonMicroservices.services;

import java.util.List;
import java.util.Optional;

import com.pokemaster.PokemonMicroservices.models.NewsFeed;

public interface NewsService {
	
	public List<NewsFeed> getAllNewsArticles();
	
	public List<NewsFeed> saveNewsArticles(List<NewsFeed> nList);
	
	public Optional<NewsFeed> getNewsArticleById(int id);
}
