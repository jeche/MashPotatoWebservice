package edu.wm.potato.model;


import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Game{
	public Game(long dayNightFreq, long creationDate, int roundCount,
			int state, GPSLocation originalLocation, int potatoCount,
			List<Player> players, Map<Integer, Player> outOrder) {
		super();
		this.dayNightFreq = dayNightFreq;
		this.creationDate = creationDate;
		this.roundCount = roundCount;
		this.state = state;
		this.originalLocation = originalLocation;
		this.potatoCount = potatoCount;
		this.players = players;
		this.outOrder = outOrder;
	}
	
	private String id;
	private long dayNightFreq;
	private long creationDate;
	private int roundCount;
	private int state;
	private GPSLocation originalLocation;
	private int potatoCount;
	private List<Player>players;
	private List<Potato>potato; 
	private Map<Integer, Player> outOrder;
	/**
	 * @return the dayNightFreq
	 */
	public long getDayNightFreq() {
		return dayNightFreq;
	}
	/**
	 * @param dayNightFreq the dayNightFreq to set
	 */
	public void setDayNightFreq(long dayNightFreq) {
		this.dayNightFreq = dayNightFreq;
	}
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
	 * @return the outOrder
	 */
	public Map<Integer, Player> getOutOrder() {
		return outOrder;
	}
	/**
	 * @param outOrder the outOrder to set
	 */
	public void setOutOrder(Map<Integer, Player> outOrder) {
		this.outOrder = outOrder;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Game [dayNightFreq=" + dayNightFreq + ", creationDate="
				+ creationDate + ", roundCount=" + roundCount + ", state="
				+ state + ", originalLocation=" + originalLocation
				+ ", potatoCount=" + potatoCount + ", players=" + players
				+ ", outOrder=" + outOrder + "]";
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
	
	
}
