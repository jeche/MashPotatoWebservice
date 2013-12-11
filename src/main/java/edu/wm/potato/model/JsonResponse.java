package edu.wm.potato.model;

import java.util.List;

public class JsonResponse {
	
	String status;
	Game game;
	List<Game> lobby;

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	public JsonResponse(String status) {
		super();
		this.status = status;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "JsonResponse [status=" + status + "]";
	}

	public void setGame(Game game) {
		this.game = game;
		// TODO Auto-generated method stub
		
	}

	/**
	 * @return the lobby
	 */
	public List<Game> getLobby() {
		return lobby;
	}

	/**
	 * @param lobby the lobby to set
	 */
	public void setLobby(List<Game> lobby) {
		this.lobby = lobby;
	}

}
