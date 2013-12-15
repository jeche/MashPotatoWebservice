package edu.wm.potato.model;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Potato")
public class Potato {
	public Potato(String pId, int multiplier, long date, Player holder,
			long l, String gameID, double[] loc, int temp) {
		super();
		this.pId = pId;
		this.multiplier = multiplier;
		this.creationDate = date;
		this.holder = holder;
		this.lifeSpan = l;
		this.gameID = gameID;
		this.loc = loc;
		this.temp = temp;
	}

	@Id
	private String pId;
	private int multiplier;
	private long creationDate;
	private int temp;
	private Player holder;
	private long lifeSpan;
	private String gameID;
	private double[] loc;
	
	
	public int getMultiplier() {
		return multiplier;
	}
	public void setMultiplier(int multiplier) {
		this.multiplier = multiplier;
	}
	public long getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(long creationDate) {
		this.creationDate = creationDate;
	}
	public Player getHolder() {
		return holder;
	}
	public void setHolder(Player holder) {
		this.holder = holder;
	}
	public long getLifeSpan() {
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
	/**
	 * @return the temp
	 */
	public int getTemp() {
		return temp;
	}
	/**
	 * @param temp the temp to set
	 */
	public void setTemp(int temp) {
		this.temp = temp;
	}
	/**
	 * @param lifeSpan the lifeSpan to set
	 */
	public void setLifeSpan(long lifeSpan) {
		this.lifeSpan = lifeSpan;
	}


}
