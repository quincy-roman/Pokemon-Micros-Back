package com.pokemaster.PokemonMicroservices.controllers;

import java.util.List;
import java.util.Optional;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import com.pokemaster.PokemonMicroservices.Runner;
import com.pokemaster.PokemonMicroservices.models.Greeting;
import com.pokemaster.PokemonMicroservices.models.NewsFeed;
import com.pokemaster.PokemonMicroservices.models.Notfication;
import com.pokemaster.PokemonMicroservices.services.NewsService;

@RestController
@RequestMapping("/news")
@CrossOrigin("http://localhost:4200")
public class NewsController {

	@Autowired
	private NewsService newsService;
	
	@Autowired
	private Runner messager;
	
	@GetMapping(path="/view/all", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<NewsFeed>> viewAllNews() throws Exception {
		System.out.println("Hello Azhya...");
		messager.run("PokeNews: gathering all news articles from database.");
		List<NewsFeed> newsList = newsService.getAllNewsArticles();
		return ResponseEntity.ok(newsList);
	}
	
	@GetMapping(path="/view/{newsId}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Optional<NewsFeed>> viewNewsArticle(@PathVariable("newsId") int newsId) throws Exception {
		messager.run("PokeNews: gathering all news articles with newsId of" + newsId +" from database.");
		Optional<NewsFeed> newsArticle = newsService.getNewsArticleById(newsId);
		return ResponseEntity.ok(newsArticle);
	}
	
	@GetMapping(path="/view/feed", produces= {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> viewRSSFeed() throws Exception {
		messager.run("Gathering RSS Feed data...");
		//first remove existing news entries from DB
		newsService.truncateNewsTable();
		//then load new content into feed
        String body = newsService.getFeed();
        return ResponseEntity.status(HttpStatus.SC_OK).body(body);
    }
	
	@MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(Notfication message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }
	
}
