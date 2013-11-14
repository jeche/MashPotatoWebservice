package edu.wm.werewolf.model;

public class JsonResponse {
	
	String status;
	String isWerewolf;
	String kills;
	String created;
	String isDead;
	String nightFreq;
	String gameStatus;

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

	/**
	 * @return the isWerewolf
	 */
	public String getIsWerewolf() {
		return isWerewolf;
	}

	/**
	 * @param isWerewolf the isWerewolf to set
	 */
	public void setIsWerewolf(String isWerewolf) {
		this.isWerewolf = isWerewolf;
	}

	/**
	 * @return the kills
	 */
	public String getKills() {
		return kills;
	}

	/**
	 * @param kills the kills to set
	 */
	public void setKills(String kills) {
		this.kills = kills;
	}

	/**
	 * @return the created
	 */
	public String getCreated() {
		return created;
	}

	/**
	 * @param created the created to set
	 */
	public void setCreated(String created) {
		this.created = created;
	}

	/**
	 * @return the isDead
	 */
	public String getIsDead() {
		return isDead;
	}

	/**
	 * @param isDead the isDead to set
	 */
	public void setIsDead(String isDead) {
		this.isDead = isDead;
	}

	/**
	 * @return the nightFreq
	 */
	public String getNightFreq() {
		return nightFreq;
	}

	/**
	 * @param nightFreq the nightFreq to set
	 */
	public void setNightFreq(String nightFreq) {
		this.nightFreq = nightFreq;
	}

	/**
	 * @return the gameStatus
	 */
	public String getGameStatus() {
		return gameStatus;
	}

	/**
	 * @param gameStatus the gameStatus to set
	 */
	public void setGameStatus(String gameStatus) {
		this.gameStatus = gameStatus;
	}
}
