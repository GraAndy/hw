package graandy.com.dao;

import graandy.com.entity.Film;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FilmDao implements IFilmDao{
@Autowired
SessionFactory sf;

@Override
public Film add_film(Film film){
	Session s = sf.getCurrentSession();
	s.save(film);
	return film;
}

@Override
public Film FilmById(Long id){
	Session s = sf.getCurrentSession();
	return (Film) s.get(Film.class, id);
}

@SuppressWarnings("unchecked")
@Override
public List<Film> get_all_films() {
	// TODO Auto-generated method stub
	Session s = sf.getCurrentSession();
	List<Film> result = s.createCriteria("graandy.com.entity.Film").list();
	return result;
}

}
