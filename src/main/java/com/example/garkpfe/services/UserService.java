package com.example.garkpfe.services;

import com.example.garkpfe.entities.Role;
import com.example.garkpfe.entities.User;
import com.example.garkpfe.exceptions.UserAlreadyExistsException;
import com.example.garkpfe.exceptions.UserNotFoundException;
import com.example.garkpfe.repositories.RoleRepository;
import com.example.garkpfe.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UserService {

    ResponseEntity<?> getAllUsers();

    ResponseEntity<?> getUserById(Integer id);
    ResponseEntity<?> updateUser(Integer id, User user);
    ResponseEntity<?> deleteUser(Integer id);
    public User desassignUser(Integer userId, Integer roleId);
    public User assignUser(Integer userId, Integer roleId) ;

}
