package edu.wm.potato.model;

public class Player extends BasicPlayer{

	// Pojo! Plain old java object
	private String id;
	private boolean isOut;
	private double lat;
	private double lng;
	private String userId;
	private boolean hasPotato;
	private String votedAgainst;
	private int score;
	private boolean hasUpdated;
	private Game game;
	
	public Player(String id, boolean isDead, double d, double e, String userId, boolean isWerewolf, boolean hasUpdated) {
		this.id = id;
		this.isOut = isDead;
		this.lat = d;
		this.lng = e;
		this.userId = userId;
		this.hasPotato = isWerewolf;
		this.score = 0;
		this.hasUpdated = hasUpdated;
	}

	public boolean isWerewolf() {
		return hasPotato;
	}

	public void setWerewolf(boolean isWerewolf) {
		this.hasPotato = isWerewolf;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isDead() {
		return isOut;
	}
	public void setDead(boolean isDead) {
		this.isOut = isDead;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getVotedAgainst() {
		return votedAgainst;
	}

	public void setVotedAgainst(String votedAgainst) {
		this.votedAgainst = votedAgainst;
	}


	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Player [id=" + id + ", isDead=" + isOut + ", lat=" + lat
				+ ", lng=" + lng + ", userId=" + userId + ", isWerewolf="
				+ hasPotato + ", votedAgainst=" + votedAgainst + ", score="
				+ score + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isOut ? 1231 : 1237);
		result = prime * result + (hasPotato ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(lat);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(lng);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + score;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result
				+ ((votedAgainst == null) ? 0 : votedAgainst.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isOut != other.isOut)
			return false;
		if (hasPotato != other.hasPotato)
			return false;
		if (Double.doubleToLongBits(lat) != Double.doubleToLongBits(other.lat))
			return false;
		if (Double.doubleToLongBits(lng) != Double.doubleToLongBits(other.lng))
			return false;
		if (score != other.score)
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (votedAgainst == null) {
			if (other.votedAgainst != null)
				return false;
		} else if (!votedAgainst.equals(other.votedAgainst))
			return false;
		return true;
	}

	/**
	 * @return the hasUpdated
	 */
	public boolean isHasUpdated() {
		return hasUpdated;
	}

	/**
	 * @param hasUpdated the hasUpdated to set
	 */
	public void setHasUpdated(boolean hasUpdated) {
		this.hasUpdated = hasUpdated;
	}
	
}
