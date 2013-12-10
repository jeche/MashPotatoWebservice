package edu.wm.potato.dao;

import java.util.List;

import edu.wm.potato.model.Game;
import edu.wm.potato.model.Potato;

public interface IPotatoDAO {

	Potato getPotatoById(String id);
	List<Potato> getPotatosByGame(Game game);
	void removePotatosByGame(Game game);
	void addPotato(Potato potato);
	void updatePotato(Potato potato);
	void removePotatoById(Potato potato);

}
