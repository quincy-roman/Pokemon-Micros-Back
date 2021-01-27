package com.pokemaster.PokemonMicroservices.util;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

@Component
public class NewsScraper {
	
	public NewsScraper() {
		// TODO Auto-generated constructor stub
	}
	
	public void loadContents() throws IOException{
		// fetch the Pokemon.com webpage
		Document doc = Jsoup.connect("https://www.pokemon.com/us/pokemon-news/").get();
		System.out.println(doc.title());
		
		// get the news titles
		Elements newsHeadlines = doc.select(".news-article .news-wrapper h3");
		for (Element headline : newsHeadlines) {
			System.out.println(headline.text());
		}
		
		// NOTE: get the other fields after testing!
	}
}
