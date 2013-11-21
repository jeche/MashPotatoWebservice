package edu.wm.potato.model;

import java.sql.Date;

public class Potato {
	
	private int multiplier;
	private Date creationDate;
	private Player holder;
	private int lifeSpan;
	private int gameID;
	private GPSLocation location;
	
	
	
	public Potato(int multiplier, Date creationDate, Player holder,
			int lifeSpan, int gameID, GPSLocation location) {
		super();
		this.multiplier = multiplier;
		this.creationDate = creationDate;
		this.holder = holder;
		this.lifeSpan = lifeSpan;
		this.gameID = gameID;
		this.location = location;
	}
	
	public Potato () {
	}
	
	public int getMultiplier() {
		return multiplier;
	}
	public void setMultiplier(int multiplier) {
		this.multiplier = multiplier;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Player getHolder() {
		return holder;
	}
	public void setHolder(Player holder) {
		this.holder = holder;
	}
	public int getLifeSpan() {
		return lifeSpan;
	}
	public void setLifeSpan(int lifeSpan) {
		this.lifeSpan = lifeSpan;
	}
	public int getGameID() {
		return gameID;
	}
	public void setGameID(int gameID) {
		this.gameID = gameID;
	}
	public GPSLocation getLocation() {
		return location;
	}
	public void setLocation(GPSLocation location) {
		this.location = location;
	}


}
