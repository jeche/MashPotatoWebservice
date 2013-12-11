package edu.wm.potato.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import edu.wm.potato.Constants;

@Document
public class Game{

	public Game(String id,
			long maxRoundTime,
			GPSLocation originalLocation, String owner) {
		super();
		this.id = id;
		this.creationDate = new Date().getTime();
		this.maxRoundTime = maxRoundTime;
		this.roundCount = 0;
		this.state = Constants.STATE_READY;
		this.originalLocation = originalLocation;
		this.potatoCount = 0;
		this.players = new ArrayList<Player>();
		this.potato = new ArrayList<Potato>();
		this.setOwner(owner);
	}
	@Id
	private String id;
	private String owner;
	private long creationDate;
	private long maxRoundTime;
	private int roundCount;
	private int state;
	private GPSLocation originalLocation;
	private int potatoCount;
	@DBRef
	private List<Player>players;
	@DBRef
	private List<Potato>potato; 
	/**
	 * @return the creationDate
	 */
	public long getCreationDate() {
		return creationDate;
	}
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(long creationDate) {
		this.creationDate = creationDate;
	}
	/**
	 * @return the roundCount
	 */
	public int getRoundCount() {
		return roundCount;
	}
	/**
	 * @param roundCount the roundCount to set
	 */
	public void setRoundCount(int roundCount) {
		this.roundCount = roundCount;
	}
	/**
	 * @return the state
	 */
	public int getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(int state) {
		this.state = state;
	}
	/**
	 * @return the originalLocation
	 */
	public GPSLocation getOriginalLocation() {
		return originalLocation;
	}
	/**
	 * @param originalLocation the originalLocation to set
	 */
	public void setOriginalLocation(GPSLocation originalLocation) {
		this.originalLocation = originalLocation;
	}
	/**
	 * @return the potatoCount
	 */
	public int getPotatoCount() {
		return potatoCount;
	}
	/**
	 * @param potatoCount the potatoCount to set
	 */
	public void setPotatoCount(int potatoCount) {
		this.potatoCount = potatoCount;
	}
	/**
	 * @return the players
	 */
	public List<Player> getPlayers() {
		return players;
	}
	/**
	 * @param players the players to set
	 */
	public void setPlayers(List<Player> players) {
		this.players = players;
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
	 * @return the potato
	 */
	public List<Potato> getPotato() {
		return potato;
	}
	/**
	 * @param potato the potato to set
	 */
	public void setPotato(List<Potato> potato) {
		this.potato = potato;
	}
	/**
	 * @return the maxRoundTime
	 */
	public long getMaxRoundTime() {
		return maxRoundTime;
	}
	/**
	 * @param maxRoundTime the maxRoundTime to set
	 */
	public void setMaxRoundTime(long maxRoundTime) {
		this.maxRoundTime = maxRoundTime;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Game [id=" + id
				+ ", creationDate=" + creationDate + ", maxRoundTime="
				+ maxRoundTime + ", roundCount=" + roundCount + ", state="
				+ state + ", originalLocation=" + originalLocation
				+ ", potatoCount=" + potatoCount + ", players=" + players
				+ ", potato=" + potato + "]";
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	
}
