package com.example.garkpfe.controllers;

import com.example.garkpfe.entities.Licencie;
import com.example.garkpfe.entities.User;
import com.example.garkpfe.payload.request.LicencieRequest;
import com.example.garkpfe.payload.request.SignupRequest;
import com.example.garkpfe.payload.response.MessageResponse;
import com.example.garkpfe.services.AuthService;
import com.example.garkpfe.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@Valid @RequestBody SignupRequest signUpRequest) {
        return userService.addUser(signUpRequest);
    }

    @PostMapping("/assign-role-to-user")
    public User assignUser(@RequestParam("userId")Integer userId,
                                 @RequestParam("roleId") Integer roleId){
        return userService.assignUser(userId, roleId);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }
    @PostMapping("/remove-role-from-user")
    public User desassignUser(@RequestParam("userId")Integer userId,
                                   @RequestParam("roleId") Integer roleId){
        return userService.desassignUser(userId, roleId);
    }
    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers() {
        return userService.getAllUsers();
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id, @RequestBody User user){
        return userService.updateUser(id,user);

    }
    @DeleteMapping("/{id}")

    public ResponseEntity<?> deleteUser(@PathVariable Integer id){
        return userService.deleteUser(id);
    }
}
