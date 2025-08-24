package ar.edu.itba.paw.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.jdbc.JdbcTestUtils;

import ar.edu.itba.paw.models.User;
import ar.edu.itba.paw.persistence.config.TestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class UserJdbcDaoTest {
	
	private static final String USERNAME = "test user";
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private UserJdbcDao userDao; 
	
	@Autowired
	private DataSource ds;
	
	@Before 
	public void setUp() {
		jdbcTemplate = new JdbcTemplate(ds);
	}

	@Test
	public void testCreate() {
		
		User user = userDao.create(USERNAME);
		
		assertNotNull(user);
		assertEquals(USERNAME, user.getUsername());
		assertEquals(1, JdbcTestUtils.countRowsInTableWhere(jdbcTemplate, "users", "username = '" + USERNAME + "'"));
		
		
	}
}
