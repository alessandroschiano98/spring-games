package org.lessons.spring.spring_games.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 2, message = "Developer must containt at least 3 characters")
    @NotBlank(message = "The title must not be blanks, empty or null")
    private String title;

    @Size(min = 2, message = "Developer must containt at least 3 characters")
    @NotBlank(message = "The developer field  must not be blanks, empty or null")
    private String developer;

    @Size(min = 2, message = "Description must contain at least 10 character")
    @NotBlank(message = "The genre field must not be blank, empty or null")
    private String genre;

    @NotNull(message = "Release date must be filled")
    private LocalDate releaseDate;

    @Lob
    @Size(min = 10, max = 2000, message = "Description must contain at least 10 character and not more than 2000")
    @NotBlank(message = "The developer field must not be blank, empty or null")
    private String description;

    @Lob
    @Size(min = 10, max = 1000, message = "Image url must containt at least 10 characters and not more than 1000")
    private String imageUrl;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeveloper() {
        return this.developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    


}
