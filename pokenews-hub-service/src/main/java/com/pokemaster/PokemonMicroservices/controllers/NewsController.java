package com.pokemaster.PokemonMicroservices.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokemaster.PokemonMicroservices.models.NewsFeed;
import com.pokemaster.PokemonMicroservices.services.NewsService;

@RestController
@RequestMapping("/news")
@CrossOrigin("http://localhost:4200")
public class NewsController {

	@Autowired
	private NewsService newsService;
	
	@GetMapping(path="/view/all", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<NewsFeed>> viewAllNews() {
		List<NewsFeed> newsList = newsService.getAllNewsArticles();
		return ResponseEntity.ok(newsList);
	}
	
	@GetMapping(path="/view/{newsId}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Optional<NewsFeed>> viewNewsArticle(@PathVariable("newsId") int newsId) {
		Optional<NewsFeed> newsArticle = newsService.getNewsArticleById(newsId);
		return ResponseEntity.ok(newsArticle);
	}
	
}
