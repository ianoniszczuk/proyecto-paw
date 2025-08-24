package ar.edu.itba.paw.persistence;

import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import ar.edu.itba.paw.interfaces.persistence.UserDao;
import ar.edu.itba.paw.models.User;

@Repository
public class UserJdbcDao implements UserDao {

	private final JdbcTemplate jdbcTemplate;
	private final SimpleJdbcInsert jdbcInsert;
	
	private static final RowMapper<User> ROW_MAPPER = 
			(rs, rowNum) -> new User(rs.getLong("userid"), rs.getString("username")); 

	public UserJdbcDao(final DataSource ds) {
		jdbcTemplate = new JdbcTemplate(ds);
		jdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
				.usingGeneratedKeyColumns("userid") 
				.withTableName("users");
		
	}

	@Override  
	public Optional<User> findById(long id) {
		
		return jdbcTemplate.query("SELECT * FROM users WHERE userid = ?", ROW_MAPPER, id)
				.stream().findFirst();

	}

	@Override
	public User create(String username) {
		final Map<String, Object> values = Map.of("username", username);
		final Number key = jdbcInsert.executeAndReturnKey(values); 
		
		return new User(key.longValue(), username);
		 
	}

}
