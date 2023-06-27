package com.guestlist.guestlist_artifact.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestListRepo extends PagingAndSortingRepository<GuestsEntity, Integer> {
	GuestsEntity findByName(String name);

	Long deleteByName(String name);

	GuestsEntity findTopByRoomtypeOrderByName(String roomType);

	List<GuestsEntity> findAllByOrderByNameDesc();
}
