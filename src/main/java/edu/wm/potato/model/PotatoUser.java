package edu.wm.potato.model;

import java.beans.Encoder;
import java.util.Collection;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthoritiesContainerImpl;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Document(collection="User")
public class PotatoUser {

	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String uId;
	private String hashedPassword;
	private int score;
	private boolean isAdmin;
	private int wins;
	private int aliveRounds;
	private int totalRounds;
	private int totalGames;

	public PotatoUser(String id, String firstName, String lastName, String uId,
			String hashedPassword, int score, boolean isAdmin, int wins,
			int aliveRounds, int totalRounds, int totalGames) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.uId = uId;
		this.hashedPassword = hashedPassword;
		this.score = score;
		this.isAdmin = isAdmin;
		this.wins = wins;
		this.aliveRounds = aliveRounds;
		this.totalRounds = totalRounds;
		this.totalGames = totalGames;
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
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the uId
	 */
	public String getuId() {
		return uId;
	}

	/**
	 * @param uId the uId to set
	 */
	public void setuId(String uId) {
		this.uId = uId;
	}

	/**
	 * @return the hashedPassword
	 */
	public String getHashedPassword() {
		return hashedPassword;
	}

	/**
	 * @param hashedPassword the hashedPassword to set
	 */
	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
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
	 * @return the isAdmin
	 */
	public boolean isAdmin() {
		return isAdmin;
	}

	/**
	 * @param isAdmin the isAdmin to set
	 */
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	/**
	 * @return the wins
	 */
	public int getWins() {
		return wins;
	}

	/**
	 * @param wins the wins to set
	 */
	public void setWins(int wins) {
		this.wins = wins;
	}

	/**
	 * @return the aliveRounds
	 */
	public int getAliveRounds() {
		return aliveRounds;
	}

	/**
	 * @param aliveRounds the aliveRounds to set
	 */
	public void setAliveRounds(int aliveRounds) {
		this.aliveRounds = aliveRounds;
	}

	/**
	 * @return the totalRounds
	 */
	public int getTotalRounds() {
		return totalRounds;
	}

	/**
	 * @param totalRounds the totalRounds to set
	 */
	public void setTotalRounds(int totalRounds) {
		this.totalRounds = totalRounds;
	}

	/**
	 * @return the totalGames
	 */
	public int getTotalGames() {
		return totalGames;
	}

	/**
	 * @param totalGames the totalGames to set
	 */
	public void setTotalGames(int totalGames) {
		this.totalGames = totalGames;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PotatoUser [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", uId=" + uId
				+ ", hashedPassword=" + hashedPassword + ", score=" + score
				+ ", isAdmin=" + isAdmin + ", wins=" + wins + ", aliveRounds="
				+ aliveRounds + ", totalRounds=" + totalRounds
				+ ", totalGames=" + totalGames + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aliveRounds;
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((hashedPassword == null) ? 0 : hashedPassword.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isAdmin ? 1231 : 1237);
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + score;
		result = prime * result + totalGames;
		result = prime * result + totalRounds;
		result = prime * result + ((uId == null) ? 0 : uId.hashCode());
		result = prime * result + wins;
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
		PotatoUser other = (PotatoUser) obj;
		if (aliveRounds != other.aliveRounds)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (hashedPassword == null) {
			if (other.hashedPassword != null)
				return false;
		} else if (!hashedPassword.equals(other.hashedPassword))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isAdmin != other.isAdmin)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (score != other.score)
			return false;
		if (totalGames != other.totalGames)
			return false;
		if (totalRounds != other.totalRounds)
			return false;
		if (uId == null) {
			if (other.uId != null)
				return false;
		} else if (!uId.equals(other.uId))
			return false;
		if (wins != other.wins)
			return false;
		return true;
	}
	
	
}
