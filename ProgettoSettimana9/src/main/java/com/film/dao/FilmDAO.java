package com.film.dao;

import java.util.List;

import com.film.model.Film;

public interface FilmDAO {

	public void salva(Film f);

	public List<Film> trovaPerRegista(String regista);

	public void aggiorna(Film f);

	public void cancella(Long id);

	public Film trovaPerId(Long id);

}
