package edu.wm.werewolf.dao;

import java.util.List;

import edu.wm.werewolf.model.Vote;
import edu.wm.werewolf.model.WerewolfUser;

public interface IVoteDAO {

	void addVote(Vote vote);
	public List<Vote> mostVotes(long l);
	void clearVotes();
}
