package com.guestlist.guestlist_artifact.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Setter
@Getter
public class Guests {
	private String name;
	private Integer room;
	private String roomtype;
	private String address;
	private String email;

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
}
