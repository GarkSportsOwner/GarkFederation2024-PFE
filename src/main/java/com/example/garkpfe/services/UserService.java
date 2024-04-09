package com.example.garkpfe.services;

import com.example.garkpfe.entities.Role;
import com.example.garkpfe.entities.User;
import com.example.garkpfe.exceptions.UserAlreadyExistsException;
import com.example.garkpfe.exceptions.UserNotFoundException;
import com.example.garkpfe.repositories.RoleRepository;
import com.example.garkpfe.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
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
