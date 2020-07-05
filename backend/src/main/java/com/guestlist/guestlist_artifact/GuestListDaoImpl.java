package com.guestlist.guestlist_artifact;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.guestlist.guestlist_artifact.Model.AddGuests;
import com.guestlist.guestlist_artifact.Model.Guests;

@Repository
public class GuestListDaoImpl extends JdbcGenericDao implements GuestListDao {
	@Override
	public List<Guests> getGuests() {
		return getJdbcTemplate().query("select * from guests",
				(rs, i) -> new Guests(rs.getString("name"), rs.getInt("room")));
	}

	@Override
	public Guests getGuestsByName(String name) {
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("name", name);
		return getNamedParameterJdbcTemplate().queryForObject("select * from guests where name=:name", paramMap,
				(rs, i) -> new Guests(rs.getString("name"), rs.getInt("room")));
	}

	@Override
	public int addGuests(AddGuests addGuests) {
		List<Guests> guests = getGuests();
		int room = 0;
		if (guests != null) {
			Collections.sort(guests, Comparator.comparing(Guests::getRoom).reversed());
			room = guests.get(0).getRoom() + 1;
		}
		Map<String, String> params = new HashMap<>();
		params.put("name", addGuests.getName());
		params.put("room", room + "");
		params.put("roomtype", addGuests.getRoomType());
		params.put("address", addGuests.getAddress());
		params.put("email", addGuests.getEmail());
		return getNamedParameterJdbcTemplate().update(
				"INSERT INTO guests (name, room,roomtype,address,email) VALUES(:name, :room,:roomtype,:address,:email)",
				params);
	}

	@Override
	public int updateGuests(AddGuests addGuests) {
		if (addGuests.getRoom() == null) {
			return addGuests(addGuests);
		}
		Map<String, String> params = new HashMap<>();
		params.put("name", addGuests.getName());
		params.put("roomtype", addGuests.getRoomType());
		params.put("address", addGuests.getAddress());
		params.put("email", addGuests.getEmail());
		params.put("room", addGuests.getRoom() + "");
		return getNamedParameterJdbcTemplate().update(
				"update guests set name = :name, roomtype=:roomtype,address =:address,email =:email where room=:room",
				params);
	}
}
