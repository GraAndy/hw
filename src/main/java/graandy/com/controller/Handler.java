package graandy.com.controller;

import graandy.com.dao.IFilmDao;
import graandy.com.entity.Film;
import graandy.com.entity.ShortFilm;
import graandy.com.util.Converter;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
 
@Controller
public class Handler {
	
	@Autowired
	IFilmDao filmDao;
	
	@RequestMapping(value = "films1", method = RequestMethod.POST)
	@Transactional
	public @ResponseBody Film printWelcome() {
		Film ob = new Film("Воздушный маршал", 2013, 
				"Великобритания, Франция, США", "детектив, триллер, боевик", 
				"1.40.10", "Хауме Кольет-Серра", 
				"Лиам Нисон, Джулианна Мур, Скут МакНэйри, Мишель Докери, Нэйт Паркер, Кори Столл, Лупита Нионго, Омар Метуолли, Джейсон Батлер Харнер, Лайнас Роуч",
				"Межконтинентальный авиарейс. Билл Маркс, воздушный маршал, который обеспечивает безопасность пассажиров, получает сообщения с угрозами от маньяка-террориста. Преступник просчитал все ходы и подставил под обвинение самого спецагента. Теперь Маркс — цель спецслужб США. Ему остается одно: вычислить и обезвредить преступника, спасти пассажиров и свою любовь, которую он обретает на краю гибели. До взрыва остаются считанные минуты…");

		ob = filmDao.add_film(ob);
		return ob;
	}
	
	@RequestMapping(value = "films", method = RequestMethod.POST)
	@Transactional
	public @ResponseBody Film add_film(@RequestBody Film film) {
		film = filmDao.add_film(film);
		return film;
	}
	 	
	
	@RequestMapping(value = "films/{id}", method = RequestMethod.GET)
	@Transactional
	public @ResponseBody Film printFilm(@PathVariable Long id) {
		Film f = filmDao.FilmById(id);
		f.setComments(Converter.commentConvert(f.getComments()));
		return f;
	}
	@RequestMapping(value = "films", method = RequestMethod.GET, params = {"name"})
	@Transactional
	public @ResponseBody List<Film> printFilmByName(String name) {
		List<Film> f = filmDao.FindByName(name);
		for (Film i : f){
		i.setComments(Converter.commentConvert(i.getComments()));
	}
		return f;
	}
	@RequestMapping(value = "films/{id}", method = RequestMethod.DELETE)
	@Transactional
	public @ResponseBody String deleteFilm(@PathVariable Long id) {
		Film f = filmDao.FilmById(id);
		f.setComments(Converter.commentConvert(f.getComments()));
		filmDao.delete_film(f);
		return "Deleted";
	}
	
	@RequestMapping(value = "films", method = RequestMethod.GET)
	@Transactional
	public @ResponseBody List<ShortFilm> displayAll() {
		List<Film> f = (List<Film>) filmDao.get_all_films();
		List<ShortFilm> s = (List<ShortFilm>) Converter.filmConvert(f);
		return s;
	}
	
}
