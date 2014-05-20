package graandy.com.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;


@Entity
public class Film {

	public Long getId() {
		return id_film;
	}

	public void setId(Long id) {
		this.id_film = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRelease_year() {
		return release_year;
	}

	public void setRelease_year(int release_year) {
		this.release_year = release_year;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getStars() {
		return stars;
	}

	public void setStars(String stars) {
		this.stars = stars;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Id
	@SequenceGenerator(name = "seq_film", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_film")
	private Long id_film;
	private String name;
	private int release_year;
	private String country;
	private String genre;
	private String duration;
	private String director;
	private String stars;
	
	@Column(length = 4000)
	private String description;

	public Long getId_film() {
		return id_film;
	}

	public void setId_film(Long id_film) {
		this.id_film = id_film;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	@OneToMany(mappedBy = "film", cascade = {CascadeType.REMOVE} )
	List<Comment> comments;

	public Film(String name, int release_year, String country, String genre,
			String duration, String director, String stars, String description) {
		super();
		this.name = name;
		this.release_year = release_year;
		this.country = country;
		this.genre = genre;
		this.duration = duration;
		this.director = director;
		this.stars = stars;
		this.description = description;
	}

	public Film() {
	}

	public void SetFilm(String name, int release_year, String country,
			String genre, String duration, String director, String stars,
			String description) {
		this.setName(name);
		this.setRelease_year(release_year);
		this.setCountry(country);
		this.setGenre(genre);
		this.setDuration(duration);
		this.setDirector(director);
		this.setStars(stars);
		this.setDescription(description);
	}

}
