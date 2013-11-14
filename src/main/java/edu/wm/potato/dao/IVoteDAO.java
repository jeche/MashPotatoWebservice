package edu.wm.potato.dao;

import java.util.List;

import edu.wm.potato.model.Vote;
import edu.wm.potato.model.WerewolfUser;

public interface IVoteDAO {

	void addVote(Vote vote);
	public List<Vote> mostVotes(long l);
	void clearVotes();
}
