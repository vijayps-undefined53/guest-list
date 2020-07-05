package com.guestlist.guestlist_artifact.Model;

import org.springframework.stereotype.Component;

@Component
public class Guests {
	String name;
	Integer room;

	public Guests() {
		super();
	}

	public Guests(String name, Integer room) {
		super();
		this.name = name;
		this.room = room;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the room
	 */
	public Integer getRoom() {
		return room;
	}

	/**
	 * @param room
	 *            the room to set
	 */
	public void setRoom(Integer room) {
		this.room = room;
	}
}
