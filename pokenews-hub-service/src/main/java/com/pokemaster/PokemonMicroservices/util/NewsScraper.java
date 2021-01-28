package com.pokemaster.PokemonMicroservices.util;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokemaster.PokemonMicroservices.models.NewsFeed;
import com.pokemaster.PokemonMicroservices.models.NewsFeedWrapper;
import com.pokemaster.PokemonMicroservices.models.NewsType;
import com.pokemaster.PokemonMicroservices.services.NewsService;
import com.pokemaster.PokemonMicroservices.services.NewsServiceImpl;

@Component
public class NewsScraper {
	
	@Autowired
	private NewsService service;

	public NewsScraper() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unused")
	public String loadContents() throws IOException {

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
			int n = newsHeadlines.size();
			List<NewsFeed> newsList = Arrays.asList(new NewsFeed[n]);;
			System.out.println(newsList.size());
			for (int i = 0; i < newsList.size(); i++) {
				NewsFeed news = new NewsFeed();
				//for POJO
				news.setAuthor(authors.get(i).text());
				news.setTitle(newsHeadlines.get(i).text());
				news.setType(NewsType.GENERAL);
				news.setDateWritten(LocalDate.now());
				news.setLink(links.get(i).attr("abs:href"));
				//call service to save the news article to database to get id
				service.saveNewsArticle(news);
				//for JSON return entity
				ObjectMapper om = new ObjectMapper();
				String[] monthDayArr = days[i].split("(?<=\\D)(?=\\d)");
				System.out.println("Array size: " + monthDayArr.length);
				NewsFeedWrapper obj = new NewsFeedWrapper(news, monthDayArr[0], monthDayArr[1], "2021");
				String newsJSON = om.writeValueAsString(obj);
				return newsJSON;
			}
			// NOTE: return formatted JSON to NewsController
		} catch (HttpStatusException ex) {
			System.out.println(ex);
		}
		return "";
	}
}
