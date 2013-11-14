package edu.wm.werewolf.model;

import java.util.Date;
import java.util.logging.Logger;

public class Game {
	private boolean isRunning;
	private long dayNightFreq;
	private long timer;
	
	public Game(long dayNightFreq, long createdDate) {
		super();
		this.dayNightFreq = dayNightFreq;
		this.timer = createdDate;
	}
	public long getDayNightFreq() {
		return dayNightFreq;
	}
	public void setDayNightFreq(long dayNightFreq) {
		this.dayNightFreq = dayNightFreq;
	}
	public boolean isRunning() {
		return isRunning;
	}
	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}
	public boolean isNight() {
		Date comp = new Date();
		if(((comp.getTime()-timer)/dayNightFreq)%2 == 0) {
			System.out.println("It is day time.");
			return false;
		}
		System.out.println("It is night time.");
		return true;
	}
	/**
	 * @return the timer
	 */
	public long getTimer() {
		return timer;
	}
	/**
	 * @param timer the timer to set
	 */
	public void setTimer(long timer) {
		this.timer = timer;
	}
}
