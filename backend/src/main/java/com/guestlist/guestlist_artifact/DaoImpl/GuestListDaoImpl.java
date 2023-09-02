package com.guestlist.guestlist_artifact.DaoImpl;

import com.guestlist.guestlist_artifact.Dao.GuestListDao;
import com.guestlist.guestlist_artifact.Model.AddGuests;
import com.guestlist.guestlist_artifact.Model.Guests;
import com.guestlist.guestlist_artifact.Repo.GuestListRepo;
import com.guestlist.guestlist_artifact.Repo.GuestsEntity;
import com.guestlist.guestlist_artifact.Repo.JdbcGenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Repository
public class GuestListDaoImpl
        extends JdbcGenericDao
        implements GuestListDao {
    @Autowired
    GuestListRepo guestListRepo;

    @Override
    public List<Guests> getGuests() {
        List<Guests> guestlist = new ArrayList<>();
        GuestsEntity guestByRoomType = guestListRepo.findTopByRoomtypeOrderByName("deluxe");
        Pageable paging = PageRequest.of(0, 10, Sort.by(Sort.Direction.ASC, "email", "name"));
        Page<GuestsEntity> sortByEmail = guestListRepo.findAll(paging);
        sortByEmail.stream().forEach((g) -> guestlist.add(
                new Guests(g.getName(), g.getRoom(), g.getRoomtype(), g.getAddress(), g.getEmail())));
//		guestListRepo.findAllByOrderByNameDesc().forEach(g -> {
//			guestlist.add(new Guests(g.getName(), g.getRoom(), g.getRoomtype(), g.getAddress(), g.getEmail()));
//		});
        return guestlist;
        /*
         * Code below shows how to get all guests using jdbc template return
         * getJdbcTemplate().query("select * from guests", (rs, i) -> new
         * Guests(rs.getString("name"), rs.getInt("room")));
         */

    }

    @Override
    public Guests getGuestsByName(String name) {
        GuestsEntity guest = guestListRepo.findByName(name);
        return guest != null ? new Guests(guest.getName(), guest.getRoom()) : null;
        /*
         * * Code below shows the above code using jdbc template return Map<String,
         * String> paramMap = new HashMap<>(); paramMap.put("name", name); return
         * getNamedParameterJdbcTemplate().
         * queryForObject("select * from guests where name=:name", paramMap, (rs, i) ->
         * new Guests(rs.getString("name"), rs.getInt("room")));
         */
    }

    @Override
    public int addGuests(AddGuests addGuests) {
        List<Guests> guests = getGuests();
        int room = 0;
        if (!CollectionUtils.isEmpty(guests)) {
            guests.sort(Comparator.comparing(Guests::getRoom).reversed());
            if (guests.stream().anyMatch(g -> g.getName().equals(addGuests.getName()))) {
                throw new InternalError("Guest Already Exists");
            }
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

    @Transactional
    @Override
    public int deleteGuests(String name) {
        GuestsEntity guestsEntity = guestListRepo.findByName(name);
        if (guestsEntity != null) {
            guestListRepo.delete(guestsEntity);
            return 1;
        } else {
            return 0;
        }
    }
}
