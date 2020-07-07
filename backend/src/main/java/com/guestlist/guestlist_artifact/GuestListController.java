package com.guestlist.guestlist_artifact;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.guestlist.guestlist_artifact.Model.AddGuests;
import com.guestlist.guestlist_artifact.Model.Guests;

@RestController
public class GuestListController {
	@Autowired
	private GuestListService guestListService;

	@RequestMapping(value = "/arrivals", method = RequestMethod.GET)
	public ResponseEntity<List<Guests>> arrivals() {
		List<Guests> arrivals = guestListService.arrivals();
		if (!CollectionUtils.isEmpty(arrivals)) {
			return new ResponseEntity<List<Guests>>(arrivals, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Guests>>(HttpStatus.NO_CONTENT);
		}
	}

	@RequestMapping(value = "/prepare", method = RequestMethod.GET)
	public ResponseEntity<Guests> prepare() {
		return new ResponseEntity<Guests>(HttpStatus.OK);
	}

	@RequestMapping(value = "/addguests", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Boolean> addGuests(@Valid @NotNull @RequestBody AddGuests addGuests) {
		return guestListService.addGuests(addGuests) == 1 ? new ResponseEntity<Boolean>(HttpStatus.OK)
				: new ResponseEntity<Boolean>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(value = "/updateguests", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Boolean> updateGuests(@Valid @NotNull @RequestBody AddGuests addGuests) {
		int addguests = guestListService.updateGuests(addGuests);
		return addguests == 1 ? new ResponseEntity<Boolean>(HttpStatus.OK)
				: new ResponseEntity<Boolean>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(value = "/getGuestByName", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Guests> getGuestByName(
			@Valid @NotNull(message = "querying using name, name expected") @RequestParam String name) {
		Guests guest = guestListService.getGuestsByName(name);
		return guest != null ? new ResponseEntity<Guests>(guest, HttpStatus.OK)
				: new ResponseEntity<Guests>(HttpStatus.NO_CONTENT);
	}
}
