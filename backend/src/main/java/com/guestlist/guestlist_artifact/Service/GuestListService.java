package com.guestlist.guestlist_artifact.Service;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.guestlist.guestlist_artifact.Model.AddGuests;
import com.guestlist.guestlist_artifact.Model.Guests;

@Service
@Profile("!test")
public interface GuestListService {
	List<Guests> arrivals();

	int addGuests(AddGuests addGuests);

	int updateGuests(AddGuests addGuests);

	Guests getGuestsByName(String name);

	int deleteGuests(String name);

}
