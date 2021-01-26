/**
* The NewsFeed model represents a single, general news title 
* for the NewsHub micro service. 
* 
* @author Azhya Knox
*/

package com.pokemaster.PokemonMicroservices.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "NEWS")
@Data
public class NewsFeed{

    @Id
    @Column(name = "newsId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int newsId; //DB-given value to track article in micro service

    @Column(name = "newsTitle")
    private String title; // main title of article

    @Column(name = "newsType")
    private NewsType type; // enum that represents the type of article -- testing with String

    @Column(name = "author")
    private String author; //person that wrote or provided source

    @Column(name = "date_written")
    private LocalDate dateWritten; // date that the article was published

    @Column(name = "newsLink")
    private String link; //web link to news article

    @Column(name = "newsKeywords")
    private String keywords; //key words for easily search item on external browser/ delimited by commas
    
    //CONSTRUCTORS
    
    //NO ARGS
    public NewsFeed() {
		// TODO Auto-generated constructor stub
	}

    //ALL BUT ID FIELD
	public NewsFeed(String title, NewsType type, String author, LocalDate dateWritten, String link, String keywords) {
		super();
		this.title = title;
		this.type = type;
		this.author = author;
		this.dateWritten = dateWritten;
		this.link = link;
		this.keywords = keywords;
	}

	//ALL ARGS
	public NewsFeed(int newsId, String title, NewsType type, String author, LocalDate dateWritten, String link,
			String keywords) {
		super();
		this.newsId = newsId;
		this.title = title;
		this.type = type;
		this.author = author;
		this.dateWritten = dateWritten;
		this.link = link;
		this.keywords = keywords;
	}
	
	//GETTERS & SETTERS

	public int getNewsId() {
		return newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public NewsType getType() {
		return type;
	}

	public void setType(NewsType type) {
		this.type = type;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDate getDateWritten() {
		return dateWritten;
	}

	public void setDateWritten(LocalDate dateWritten) {
		this.dateWritten = dateWritten;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((dateWritten == null) ? 0 : dateWritten.hashCode());
		result = prime * result + ((keywords == null) ? 0 : keywords.hashCode());
		result = prime * result + ((link == null) ? 0 : link.hashCode());
		result = prime * result + newsId;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NewsFeed other = (NewsFeed) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (dateWritten == null) {
			if (other.dateWritten != null)
				return false;
		} else if (!dateWritten.equals(other.dateWritten))
			return false;
		if (keywords == null) {
			if (other.keywords != null)
				return false;
		} else if (!keywords.equals(other.keywords))
			return false;
		if (link == null) {
			if (other.link != null)
				return false;
		} else if (!link.equals(other.link))
			return false;
		if (newsId != other.newsId)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NewsFeed [newsId=" + newsId + ", title=" + title + ", type=" + type + ", author=" + author
				+ ", dateWritten=" + dateWritten + ", link=" + link + ", keywords=" + keywords + "]";
	}
}