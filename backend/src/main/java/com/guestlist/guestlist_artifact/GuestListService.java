package com.guestlist.guestlist_artifact;

import java.util.List;

import org.springframework.stereotype.Service;

import com.guestlist.guestlist_artifact.Model.AddGuests;
import com.guestlist.guestlist_artifact.Model.Guests;

@Service
public interface GuestListService {
	List<Guests> arrivals();

	int addGuests(AddGuests addGuests);

	int updateGuests(AddGuests addGuests);

	Guests getGuestsByName(String name);

}
