package edu.wm.potato.model;

import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Potato")
public class Potato {
	public Potato(String pId, int multiplier, Date creationDate, Player holder,
			int lifeSpan, String gameID, double[] loc) {
		super();
		this.pId = pId;
		this.multiplier = multiplier;
		this.creationDate = creationDate;
		this.holder = holder;
		this.lifeSpan = lifeSpan;
		this.gameID = gameID;
		this.loc = loc;
	}

	@Id
	private String pId;
	private int multiplier;
	private Date creationDate;
	private Player holder;
	private int lifeSpan;
	private String gameID;
	private double[] loc;
	
	

	
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
	public String getGameID() {
		return gameID;
	}
	public void setGameID(String gameID) {
		this.gameID = gameID;
	}
	/**
	 * @return the pId
	 */
	public String getpId() {
		return pId;
	}

	/**
	 * @param pId the pId to set
	 */
	public void setpId(String pId) {
		this.pId = pId;
	}

	/**
	 * @return the loc
	 */
	public double[] getLoc() {
		return loc;
	}

	/**
	 * @param loc the loc to set
	 */
	public void setLoc(double[] loc) {
		this.loc = loc;
	}


}
