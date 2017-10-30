package edu.mum.cs.cs544.examples;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Film {
	@Id
	@Column(name="film_id")
	@GeneratedValue	
	private Long id;
	
	private String title;
	private String description;
	private String rating;
	
	@Column(name="release_year")
	private String releaseYear;
	
	@ManyToMany(mappedBy="films")
	private List<Actor> actors = new ArrayList<Actor>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", title=" + title + ", rating=" + rating
				+ ", releaseYear=" + releaseYear + "]";
	}

}
