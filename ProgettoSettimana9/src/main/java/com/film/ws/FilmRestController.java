package com.film.ws;

import java.util.List;

import com.film.dao.FilmDAO;
import com.film.dao.FilmDAOImpl;
import com.film.model.Film;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/film")
public class FilmRestController {

	/// insert//
	@PostMapping("/inserisci")
	public ResponseEntity<String> salva(@RequestBody Film f) {
		FilmDAO fdao = new FilmDAOImpl();
		fdao.salva(f);
		return new ResponseEntity<String>("Inserimento film effettuato con successo", HttpStatus.OK);
	}

//update//
	@PutMapping("/aggiorna")
	public ResponseEntity<String> aggiorna(@RequestBody Film f) {
		FilmDAO fdao = new FilmDAOImpl();
		fdao.aggiorna(f);
		return new ResponseEntity<String>("Aggiornamento film effettuato con successo", HttpStatus.OK);

	}

//delete//
	@DeleteMapping("/elimina/{id}")
	public ResponseEntity<String> elimina(@PathVariable Long id) {
		FilmDAO fdao = new FilmDAOImpl();
		fdao.cancella(id);
		return new ResponseEntity<String>("Eliminazione film effettuata con successo", HttpStatus.OK);
	}

//getbyid//
	@GetMapping("/id/{id}")
	public ResponseEntity<Film> trovaPerId(@PathVariable Long id) {
		FilmDAO fdao = new FilmDAOImpl();
		Film f = fdao.trovaPerId(id);
		return new ResponseEntity<Film>(f, HttpStatus.OK);
	}

//getbyregista//
	@GetMapping("/regista/{regista}")
	public ResponseEntity<List<Film>> trovaPerRegista(@PathVariable String regista) {
		FilmDAO filmDao = new FilmDAOImpl();
		List<Film> f = filmDao.trovaPerRegista(regista);

		return new ResponseEntity<List<Film>>(f, HttpStatus.OK);
	}

}
