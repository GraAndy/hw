package graandy.com.dao;

import graandy.com.entity.Film;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Cascade;
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
public Boolean delete_film(Film film){
	Session s = sf.getCurrentSession();
	s.delete(film);
	return true;
}

@Override
public Film FilmById(Long id){
	Session s = sf.getCurrentSession();
	return (Film) s.get(Film.class, id);
}

@SuppressWarnings("unchecked")
@Override
public List<Film> get_all_films() {
	Session s = sf.getCurrentSession();
	List<Film> result = s.createCriteria("graandy.com.entity.Film").list();
	return result;
}
@SuppressWarnings("unchecked")
@Override
public List<Film> FindByName(String name){
	Session s = sf.getCurrentSession();
	Query q = s.createQuery("from graandy.com.entity.Film s where s.name = :name");
	q.setParameter("name", name);
	List<Film> result = q.list();
	return result;
}
}
