package com.guestlist.guestlist_artifact.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Component
@NoArgsConstructor
@Setter
@Getter
public class AddGuests {
	@Pattern(regexp = "[a-zA-Z]{2,12}$",
			 message = "username must be of 2 to 12 length with no special characters or numbers")
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
}
