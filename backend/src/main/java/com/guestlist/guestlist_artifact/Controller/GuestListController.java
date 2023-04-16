package com.guestlist.guestlist_artifact.Controller;

import com.guestlist.guestlist_artifact.Model.AddGuests;
import com.guestlist.guestlist_artifact.Model.Guests;
import com.guestlist.guestlist_artifact.Service.GuestListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Slf4j
public class GuestListController {
	@Autowired
	private GuestListService guestListService;

	@RequestMapping(value = "/arrivals", method = RequestMethod.GET)
	public ResponseEntity<List<Guests>> arrivals() {
		log.info("Arrivals Api , to get list of guest arriving ");
		List<Guests> arrivals = guestListService.arrivals();
		if (!CollectionUtils.isEmpty(arrivals)) {
			return new ResponseEntity<List<Guests>>(arrivals, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Guests>>(HttpStatus.NO_CONTENT);
		}
	}

	@RequestMapping(value = "/prepare", method = RequestMethod.GET)
	public ResponseEntity<Guests> prepare() {
		log.info("Prepare Api ");
		return new ResponseEntity<Guests>(HttpStatus.OK);
	}

	@RequestMapping(value = "/addguests", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Boolean> addGuests(@Valid @NotNull @RequestBody AddGuests addGuests) {
		log.info("addguests Api ");
		int add = guestListService.addGuests(addGuests);
		log.info("Successfully added guests  ");
		return add == 1 ? new ResponseEntity<Boolean>(HttpStatus.OK)
				: new ResponseEntity<Boolean>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(value = "/updateguests", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Boolean> updateGuests(@Valid @NotNull @RequestBody AddGuests addGuests) {
		log.info("updateGuests Api ");
		int addguests = guestListService.updateGuests(addGuests);
		log.info("Successfully updated Guests  ");
		return addguests == 1 ? new ResponseEntity<Boolean>(HttpStatus.OK)
				: new ResponseEntity<Boolean>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(value = "/getGuestByName", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Guests> getGuestByName(
			@Valid @NotNull(message = "querying using name, name expected") @RequestParam String name) {
		log.info("getGuestByName Api ");
		Guests guest = guestListService.getGuestsByName(name);
		log.info("Guest Retrieved");
		return guest != null ? new ResponseEntity<Guests>(guest, HttpStatus.OK)
				: new ResponseEntity<Guests>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/deleteGuestByName", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<String> deleteGuestByName(
			@Valid @NotNull(message = "delete using name, name expected") @RequestParam String name) {
		int deleted = guestListService.deleteGuests(name);
		return deleted == 1 ? new ResponseEntity<String>("Guest Deleted", HttpStatus.OK)
				: new ResponseEntity<String>("No guest with this name found", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
