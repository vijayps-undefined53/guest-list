package com.guestlist.guestlist_artifact.Controller;

import java.util.HashMap;
import java.util.Map;

import com.guestlist.guestlist_artifact.Repo.JdbcGenericDao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.guestlist.guestlist_artifact.Model.User;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Repository
public class LoginController extends JdbcGenericDao {
	private static final String NAME = "name";
	private static final String PASSWORD = "password";

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ResponseEntity<User> index(@RequestParam String name, @RequestParam String password) {
		String sql = "select * from user u where u.name=:name and u.password=:password";
		Map<String, String> params = new HashMap<>();
		params.put(NAME, name);
		params.put(PASSWORD, password);
		SqlParameterSource paramMap = new MapSqlParameterSource(params);
		User user = getNamedParameterJdbcTemplate().queryForObject(sql, paramMap,
				(rs, i) -> new User(rs.getString(NAME), rs.getString(PASSWORD)));
		return (user != null) ? new ResponseEntity<User>(user, HttpStatus.OK)
				: new ResponseEntity<User>(HttpStatus.FORBIDDEN);
	}
}
