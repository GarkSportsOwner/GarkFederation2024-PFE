package com.example.garkpfe.services.servicesImpl;

import com.example.garkpfe.entities.Role;
import com.example.garkpfe.entities.User;
import com.example.garkpfe.exceptions.UserAlreadyExistsException;
import com.example.garkpfe.exceptions.UserNotFoundException;
import com.example.garkpfe.repositories.RoleRepository;
import com.example.garkpfe.repositories.UserRepository;
import com.example.garkpfe.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class UserServiceImpl implements UserService {
    @Autowired
    private  RoleRepository roleRepository;
    @Autowired
    private  UserRepository userRepository;
    public ResponseEntity<?> getAllUsers() {
        List<User> users = userRepository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    public ResponseEntity<User> getUserById(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


    public ResponseEntity<?> updateUser(Integer id, User user) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User existingUser = userOptional.get();
            existingUser.setEmail(user.getEmail());
            existingUser.setName(user.getName());
            existingUser.setPassword(user.getPassword());
            User updatedUser = userRepository.save(user);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> deleteUser(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            userRepository.deleteById(id);
            return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }
    public User assignUser(Integer userId, Integer roleId) {
        Optional<User> user = userRepository.findById(userId);
        Optional<Role> role = roleRepository.findById(roleId);
        if (user.isPresent() && user.get().getRoles().contains(role.get())){
            throw new UserAlreadyExistsException(
                    user.get().getName()+ " is already assigned to the " + role.get().getName() +" role");
        }
        role.ifPresent(theRole -> theRole.assignUser(user.get()));
        roleRepository.save(role.get());
        return user.get();
    }
    public User desassignUser(Integer userId, Integer roleId) {
        Optional<User> user = userRepository.findById(userId);
        Optional<Role> role = roleRepository.findById(roleId);
        if (role.isPresent() && role.get().getUsers().contains(user.get())) {
            role.get().desassignUser(user.get());
            roleRepository.save(role.get());
            return user.get();
        }
        throw new UserNotFoundException("User not found!");
    }
}


