package com.guestlist.guestlist_artifact;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestListRepo extends CrudRepository<GuestsEntity, Integer> {
	GuestsEntity findByName(String name);
}
