package com.guestlist.guestlist_artifact;

import com.guestlist.guestlist_artifact.Repo.GuestListRepo;
import com.guestlist.guestlist_artifact.Repo.GuestsEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
@Sql(scripts = "/test.sql")
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.properties")
class GuestlistArtifactApplicationTests {

    @Autowired
    private GuestListRepo guestListRepo;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(GuestlistArtifactApplicationTests.class);
    }

    @Test
    void findUsersByNameLongerThanTest() {
        GuestsEntity users = guestListRepo.findByName("test2");
        Assertions.assertEquals("test2@gmail.com", users.getEmail());
    }
}
