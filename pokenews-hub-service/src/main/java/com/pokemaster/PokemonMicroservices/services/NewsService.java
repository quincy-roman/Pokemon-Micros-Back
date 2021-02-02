package com.pokemaster.PokemonMicroservices.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.pokemaster.PokemonMicroservices.models.NewsFeed;

public interface NewsService {
	
	public List<NewsFeed> getAllNewsArticles();
	
	public String getFeed() throws IOException;
	
	public List<NewsFeed> saveNewsArticles(List<NewsFeed> nList);
	
	public NewsFeed saveNewsArticle(NewsFeed n);
	
	public Optional<NewsFeed> getNewsArticleById(int id);
}
