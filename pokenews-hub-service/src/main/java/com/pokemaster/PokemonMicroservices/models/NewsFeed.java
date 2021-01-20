/**
* The NewsFeed model represents a single, general news title for the NewsHub microservice. 
* 
* NOTE: do not know if package folder structure is the same as gatcha - cause weird error below
* @author Azhya Knox
// package main.java.com.pokemaster.PokemonMicroservices.models;
*/


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "news-feed")
@Data
public class NewsFeed{

    @Id
    @Column(name = "newsId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int newsId; //DB-given value to track article in microservice

    @Column(name = "newsTitle")
    private String title; // main title of article

    @Column(name = "newsId")
    private NewsType type; // enum that represents the type of article

    @Column(name = "author")
    private String author; //person that wrote or provided source

    @Column(name = "date_written")
    private LocalDate dateWritten; // date that the article was published

    @Column(name = "newsLink")
    private String link; //web link to news article

    @Column(name = "newsKeywords")
    private String[] keywords; //key words for easily search item on external browser
}