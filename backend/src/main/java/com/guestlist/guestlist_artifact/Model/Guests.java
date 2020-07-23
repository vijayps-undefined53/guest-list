package com.guestlist.guestlist_artifact.Model;

import org.springframework.stereotype.Component;

@Component
public class Guests {
	private String name;
	private Integer room;
	private String roomtype;
	private String address;
	private String email;

	public Guests() {
		super();
	}

	public Guests(String name, Integer room) {
		super();
		this.name = name;
		this.room = room;
	}

	public Guests(String name, Integer room, String roomtype, String address, String email) {
		super();
		this.name = name;
		this.room = room;
		this.roomtype = roomtype;
		this.address = address;
		this.email = email;
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

	/**
	 * @return the roomtype
	 */
	public String getRoomtype() {
		return roomtype;
	}

	/**
	 * @param roomtype
	 *            the roomtype to set
	 */
	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}
