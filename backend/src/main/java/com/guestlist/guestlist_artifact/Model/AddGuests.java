package com.guestlist.guestlist_artifact.Model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

@Component
public class AddGuests {
	@NotEmpty(message = "Guest's Name  shouldn't be Empty")
	private String name;
	@NotEmpty(message = "Room Type  shouldn't be Empty")
	private String roomType;
	@NotEmpty(message = "Address shouldn't be Empty")
	private String address;
	@Email(message = "{email}")
	private String email;
	private Integer room;

	public AddGuests(String name, String roomType, String address, String email) {
		super();
		this.name = name;
		this.roomType = roomType;
		this.address = address;
		this.email = email;
	}

	public AddGuests() {
		super();
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
	 * @return the roomType
	 */
	public String getRoomType() {
		return roomType;
	}

	/**
	 * @param roomType
	 *            the roomType to set
	 */
	public void setRoomType(String roomType) {
		this.roomType = roomType;
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
