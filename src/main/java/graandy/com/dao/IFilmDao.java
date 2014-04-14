package graandy.com.dao;

import java.util.List;

import graandy.com.entity.Film;

public interface IFilmDao {

	Film add_film(Film film);

	Film FilmById(Long id);
	
	List<Film> get_all_films();
}
