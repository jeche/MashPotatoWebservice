package edu.wm.werewolf.model;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import edu.wm.werewolf.service.GameService;

public class Vote {
	private String name; //votedAgainst
	private int numVotes;
	private long creationDate;
	public Vote(String name, int numVotes, long dayNightFreq, long gameStart) {
		super();
		this.name = name;
		this.numVotes = numVotes;
		Date date = new Date();
		creationDate = date.getTime();
		creationDate = (creationDate - gameStart)/(dayNightFreq * 2 );
	}
	/**
	 * @return the creation date
	 */
	public long getCreatedDate() {
		return creationDate;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the numVotes
	 */
	public int getNumVotes() {
		return numVotes;
	}
	/**
	 * @param numVotes the numVotes to set
	 */
	public void setNumVotes(int numVotes) {
		this.numVotes = numVotes;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vote other = (Vote) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
