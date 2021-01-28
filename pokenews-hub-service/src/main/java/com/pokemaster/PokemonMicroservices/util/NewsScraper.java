package com.pokemaster.PokemonMicroservices.util;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.HttpStatusException;
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

	public void loadContents() throws IOException {

		try {
			// fetch the Pokemon.com webpage
			Document doc = Jsoup.connect("https://bulbagarden.net/").get();
			System.out.println("Page Title: " + doc.title());
			// System.out.println(doc);
			
			// get the news titles
			Elements eles = doc.select("div.news-article-card-header");
			Elements newsHeadlines = eles.select("h2 a");
			Elements authors = eles.select(".author");
			System.out.println("Headlines: " + newsHeadlines.size() + "\n");
			
			for (Element headline : newsHeadlines) {
				System.out.println("Headline: " + headline.text());
			}
			System.out.println("-------------------------");
			System.out.println("Authors: " + authors.size() + "\n");
			for (Element author : authors) {
				System.out.println("Author: " + author.text());
			}
			
			Elements dateCards = doc.select(".news-article-card-date");
			String[] days = dateCards.text().split(" ");
			System.out.println("-------------------------");
			System.out.println("Dates: " + days.length + "\n");
			
			for (int i = 0; i < dateCards.size(); i++) {
				System.out.println("Date: " + days[i]);
			}

			Elements descs = doc.select(".news-article-card-excerpt");
			System.out.println("-------------------------");
			System.out.println("Descriptions: " + descs.size() + "\n");
			for (Element element : descs) {
				System.out.println("Content: " + element.text());
			}
			
			Elements keywords = doc.select(".news-tag a");
			System.out.println("-------------------------");
			System.out.println("Keywords: " + keywords.size() + "\n");
			for (Element element : keywords) {
				System.out.println("Keyword: " + element.text());
			}
			
			Elements links = doc.select(".news-cta-link");
			System.out.println("-------------------------");
			System.out.println("Links: " + links.size() + "\n");
			for (Element element : links) {
				if(!element.attr("abs:href").equals("")) {
					System.out.println("Link: " + element.attr("abs:href"));
				}else {
					System.out.println("Link: N/A");
				}
			}
			
			// NOTE: make this fetched data into JSON
			// NOTE: return formatted JSON to NewsController
		} catch (HttpStatusException ex) {
			System.out.println(ex);
		}
	}
	
	public static void main(String[] args) throws IOException {
		NewsScraper n = new NewsScraper();
		
		n.loadContents();
	}
}
