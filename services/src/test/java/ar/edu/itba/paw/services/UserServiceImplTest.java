package ar.edu.itba.paw.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import ar.edu.itba.paw.interfaces.persistence.UserDao;
import ar.edu.itba.paw.models.User;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    private static final String TEST_USERNAME = "test user";
    private static final long VALID_ID = 1;
    private static final long NONEXISTING_ID = 34534;
    private static final long INVALID_ID = -9;

    @InjectMocks
    private UserServiceImpl us;  
    @Mock
    private UserDao userDaoMock;  

    @Test
    public void testFindByIdSuccess() {
        when(userDaoMock.findById(eq(VALID_ID)))
            .thenReturn(Optional.of(new User(VALID_ID, TEST_USERNAME)));

        Optional<User> maybeUser = us.findById(VALID_ID);

        assertNotNull(maybeUser);
        assertTrue(maybeUser.isPresent());
        assertEquals(VALID_ID, maybeUser.get().getId());
    }

    @Test
    public void testFindByIdNotFound() {
        when(userDaoMock.findById(eq(NONEXISTING_ID)))
            .thenReturn(Optional.empty());

        Optional<User> maybeUser = us.findById(NONEXISTING_ID);

        assertNotNull(maybeUser);
        assertTrue(maybeUser.isEmpty());
    }

    @Test
    public void testFindByIdIllegalArg() {
        Optional<User> maybeUser = us.findById(INVALID_ID);

        assertNotNull(maybeUser);
        assertTrue(maybeUser.isEmpty());
    }

    @Test
    public void testCreateSuccess() {
        when(userDaoMock.create(eq(TEST_USERNAME)))
            .thenReturn(new User(1, TEST_USERNAME));

        User user = us.create(TEST_USERNAME);

        assertNotNull(user);
        assertEquals(TEST_USERNAME, user.getUsername());
    }
}
