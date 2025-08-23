package ar.edu.itba.paw.interfaces.persistence;

import java.util.Optional;

import ar.edu.itba.paw.models.User;

public interface UserDao {
	
    Optional<User> findById(long id);
    
    public User create(String username);
}
