package graandy.com.controller;

import java.util.List;

import javax.transaction.Transactional;

import graandy.com.dao.IFilmDao;
import graandy.com.entity.Film;

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
	public @ResponseBody Film Add_film(@RequestBody Film film) {
		film = filmDao.add_film(film);
		return film;
	}
	
	@RequestMapping("hello")
	@Transactional
	public @ResponseBody String printWelcomePerson(String name, Double number) {
		return "Hi " + name + ", your number is " + number;
	}
	
	@RequestMapping(value = "films/{id}", method = RequestMethod.GET)
	@Transactional
	public @ResponseBody Film printFilm(@PathVariable Long id) {
		//if (filmDao.FilmById(id) == null)
		
		return filmDao.FilmById(id);
	}
	@RequestMapping(value = "films", method = RequestMethod.GET)
	@Transactional
	public @ResponseBody List<Film> Display_all() {	
		return (List<Film>) filmDao.get_all_films();
	}
	
	
	
}
