package com.carrent.service;

import com.carrent.dao.entities.User;
import com.carrent.dao.repository.UserRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

    }


    @Override
    public void save(User user) throws DataAccessException {
        try {
            userRepository.save(user);
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);
        }

    }

    @Override
    public void delete(Long id) throws DataAccessException {
        try {
            userRepository.deleteById(id);
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);
        }

    }


    @Override
    public List<User> findAll() throws DataAccessException {
        try {
            userRepository.findAll();
            return userRepository.findAll();
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);
        }

    }

    @Override
    public User findUserById(Long id) throws DataAccessException {
        try {
            userRepository.findUserById(id);
            return userRepository.findUserById(id);
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);
        }

    }

    @Override
    public User findUserByUsername(String name) throws DataAccessException {
        try {
            userRepository.findByUsername(name);
            return userRepository.findByUsername(name);
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);
        }

    }


    @Override
    public boolean isExists(User user) throws DataAccessException {
        try {
            userRepository.findAll();
            return userRepository.findAll().stream()
                    .map(User::getUsername)
                    .allMatch(name -> name.equals(user.getUsername()));
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);
        }

    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        try {
            userRepository.findByUsername(username);
            return userRepository.findByUsername(username);
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);
        }

    }
}