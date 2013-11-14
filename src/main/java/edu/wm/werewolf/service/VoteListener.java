package edu.wm.werewolf.service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.wm.werewolf.model.Player;
import edu.wm.werewolf.model.Vote;

public class VoteListener implements ActionListener {
	@Autowired private GameService gameService;
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
/*		List<Vote> voteList = new ArrayList<Vote>();
		List<Player> playerList = gameService.getAllAlive();
		Vote vote;
		for(int i = 0; i < playerList.size(); i++) {
//			vote = new Vote(playerList.get(i).getVotedAgainst(), 1);
			if(voteList.contains(vote)) {
				voteList.get(voteList.indexOf(vote)).setNumVotes(voteList.get(voteList.indexOf(vote)).getNumVotes() + 1);
			}
		else {
			voteList.add(vote);
		}
	}
	int max = 0;
	int j = 0;
	while(j < voteList.size())
	{
		if(voteList.get(j).getNumVotes() < max) {
			voteList.remove(voteList.get(j));
		}
		else {
			max = voteList.get(j).getNumVotes();
			j++;
		}
	}
	if(max > 0) {
		for(int k = 0; k < voteList.size(); k++) {
			gameService.voteKill(voteList.get(k).getName());
		}
//	}}*/
	}
	}

