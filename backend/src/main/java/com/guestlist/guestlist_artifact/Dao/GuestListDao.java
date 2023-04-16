package com.guestlist.guestlist_artifact.Dao;

import java.util.List;

import com.guestlist.guestlist_artifact.Model.AddGuests;
import com.guestlist.guestlist_artifact.Model.Guests;

public interface GuestListDao {
	List<Guests> getGuests();

	int addGuests(AddGuests addGuests);

	int updateGuests(AddGuests addGuests);

	Guests getGuestsByName(String name);

	int deleteGuests(String name);
}
