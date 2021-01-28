package com.pokemaster.PokemonMicroservices.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.pokemaster.PokemonMicroservices.models.NewsFeed;

import com.pokemaster.PokemonMicroservices.repositories.NewsRepository;
import com.pokemaster.PokemonMicroservices.util.NewsScraper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl implements NewsService {
	
	@Autowired
	NewsRepository newsRepo;
	
	@Autowired
	NewsScraper n;

	@Override
	public List<NewsFeed> getAllNewsArticles() {
		List<NewsFeed> list = newsRepo.findAll();
		return list;
	}

	@Override
	public List<NewsFeed> saveNewsArticles(List<NewsFeed> nList) {
		List<NewsFeed> list = newsRepo.saveAll(nList);
		return list;
	}

	@Override
	public Optional<NewsFeed> getNewsArticleById(int id) {
		Optional<NewsFeed> news = newsRepo.findById(id);
		return news;
	}

	@Override
	public NewsFeed saveNewsArticle(NewsFeed n) {
		System.out.println(n);
		NewsFeed news = newsRepo.save(n);
		return news;
	}

	@Override
	public String getFeed() throws IOException {
		return n.loadContents();
	}

}
