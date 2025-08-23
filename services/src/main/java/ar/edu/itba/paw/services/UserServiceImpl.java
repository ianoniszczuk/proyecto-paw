package ar.edu.itba.paw.services;

import ar.edu.itba.paw.interfaces.persistence.UserDao;
import ar.edu.itba.paw.interfaces.services.UserService;
import ar.edu.itba.paw.models.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

	private final UserDao userDao;

	public UserServiceImpl(final UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public Optional<User> findById(long id) {
	    if (id <= 0) {
	        return Optional.empty(); 
	    }
	    return userDao.findById(id);
	}


	@Override
	public User create(String username) {
		return userDao.create(username);
	}
}
