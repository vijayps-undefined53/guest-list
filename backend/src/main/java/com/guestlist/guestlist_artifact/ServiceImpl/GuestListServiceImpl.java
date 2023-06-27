package com.guestlist.guestlist_artifact.ServiceImpl;

import java.util.List;

import com.guestlist.guestlist_artifact.Dao.GuestListDao;
import com.guestlist.guestlist_artifact.Service.GuestListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guestlist.guestlist_artifact.Model.AddGuests;
import com.guestlist.guestlist_artifact.Model.Guests;

@Service
@Profile("!test")
public class 	GuestListServiceImpl implements GuestListService {

	@Autowired
	GuestListDao guestListDao;

	@Override
	@Transactional
	public List<Guests> arrivals() {
		return guestListDao.getGuests();
	}

	@Override
	public int addGuests(AddGuests addGuests) {
		return guestListDao.addGuests(addGuests);
	}

	@Override
	public int updateGuests(AddGuests addGuests) {
		return guestListDao.updateGuests(addGuests);
	}

	@Override
	public Guests getGuestsByName(String name) {
		return guestListDao.getGuestsByName(name);
	}

	@Override
	public int deleteGuests(String name) {
		return guestListDao.deleteGuests(name);
	}
}
