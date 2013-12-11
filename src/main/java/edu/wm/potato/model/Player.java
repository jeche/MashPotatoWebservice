package edu.wm.potato.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Player")
public class Player {
	
	// Pojo! Plain old java object
	
	@Id
	private String id;
	private boolean isOut;
	private double lat;
	private double lng;
	private String userId;
	private boolean hasString;
	private int score;
	private String game;
	private List<String> itemList;
	private List<String> potatoList;
	
	public Player(String id, boolean isOut, double lat, double lng,
			String userId, boolean hasString, int score,
			List<String> itemList, List<String> potatoList) {
		super();
		this.id = userId;
		this.isOut = isOut;
		this.lat = lat;
		this.lng = lng;
		this.userId = userId;
		this.hasString = hasString;
		this.score = score;
		this.game = "";
		this.itemList = new ArrayList<String>();
		this.potatoList = new ArrayList<String>();
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the isOut
	 */
	public boolean isOut() {
		return isOut;
	}
	/**
	 * @param isOut the isOut to set
	 */
	public void setOut(boolean isOut) {
		this.isOut = isOut;
	}
	/**
	 * @return the lat
	 */
	public double getLat() {
		return lat;
	}
	/**
	 * @param lat the lat to set
	 */
	public void setLat(double lat) {
		this.lat = lat;
	}
	/**
	 * @return the lng
	 */
	public double getLng() {
		return lng;
	}
	/**
	 * @param lng the lng to set
	 */
	public void setLng(double lng) {
		this.lng = lng;
	}
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the hasString
	 */
	public boolean isHasString() {
		return hasString;
	}
	/**
	 * @param hasString the hasString to set
	 */
	public void setHasString(boolean hasString) {
		this.hasString = hasString;
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
	/**
	 * @return the itemList
	 */
	public List<String> getItemList() {
		return itemList;
	}
	/**
	 * @param itemList the itemList to set
	 */
	public void setItemList(List<String> itemList) {
		this.itemList = itemList;
	}
	/**
	 * @return the potatoList
	 */
	public List<String> getPotatoList() {
		return potatoList;
	}
	/**
	 * @param potatoList the potatoList to set
	 */
	public void setPotatoList(List<String> potatoList) {
		this.potatoList = potatoList;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (hasString ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isOut ? 1231 : 1237);
		result = prime * result
				+ ((itemList == null) ? 0 : itemList.hashCode());
		long temp;
		temp = Double.doubleToLongBits(lat);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(lng);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((potatoList == null) ? 0 : potatoList.hashCode());
		result = prime * result + score;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		if (hasString != other.hasString)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isOut != other.isOut)
			return false;
		if (itemList == null) {
			if (other.itemList != null)
				return false;
		} else if (!itemList.equals(other.itemList))
			return false;
		if (Double.doubleToLongBits(lat) != Double.doubleToLongBits(other.lat))
			return false;
		if (Double.doubleToLongBits(lng) != Double.doubleToLongBits(other.lng))
			return false;
		if (potatoList == null) {
			if (other.potatoList != null)
				return false;
		} else if (!potatoList.equals(other.potatoList))
			return false;
		if (score != other.score)
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Player [id=" + id + ", isOut=" + isOut + ", lat=" + lat
				+ ", lng=" + lng + ", userId=" + userId + ", hasString="
				+ hasString + ", score=" + score + ", game=" + game
				+ ", itemList=" + itemList + ", potatoList=" + potatoList + "]";
	}

	/**
	 * @return the gameID
	 */
	public String getGame() {
		return game;
	}

	/**
	 * @param gameID the gameID to set
	 */
	public void setGame(String game) {
		this.game = game;
	}
	
	
}
