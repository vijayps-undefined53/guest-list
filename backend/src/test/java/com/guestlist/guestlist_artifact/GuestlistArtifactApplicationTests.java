package com.guestlist.guestlist_artifact;

import com.guestlist.guestlist_artifact.Model.User;
import com.guestlist.guestlist_artifact.Repo.GuestListRepo;
import com.guestlist.guestlist_artifact.Repo.GuestsEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@DataJpaTest
@Sql(scripts = "/test.sql")
@ActiveProfiles("test")
class GuestlistArtifactApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private GuestListRepo guestListRepo;

	@Test
	void findUsersByNameLongerThanTest() {
		GuestsEntity users = guestListRepo.findByName("test2");
		Assertions.assertEquals("test2@gmail.com", users.getEmail());
	}
}
