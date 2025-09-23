package lk.ijse.aad.spice_ceylon_backend.service;

import lk.ijse.aad.spice_ceylon_backend.dto.RegisterDTO;
import lombok.RequiredArgsConstructor;
import lk.ijse.aad.spice_ceylon_backend.dto.AuthDTO;
import lk.ijse.aad.spice_ceylon_backend.dto.AuthResponseDTO;
import lk.ijse.aad.spice_ceylon_backend.entity.Role;
import lk.ijse.aad.spice_ceylon_backend.repository.UserRepository;
import lk.ijse.aad.spice_ceylon_backend.util.JwtUtil;
import org.apache.catalina.User;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthResponseDTO authenticate(AuthDTO authDTO){
        // validate credentials
        User user=userRepository.findByUsername(authDTO.getUsername())
                .orElseThrow(()->new RuntimeException("User not found"));
        // check password
        if (!passwordEncoder.matches(
                authDTO.getPassword(),
                user.getPassword())){
            throw new BadCredentialsException("Invalid credentials");
        }
        // generate token
        String token=jwtUtil.generateToken(authDTO.username);
        return new AuthResponseDTO(token);
    }
    // register user
    public String register(RegisterDTO registerDTO){
        if (userRepository.findByUsername(registerDTO.getUsername())
                .isPresent()){
            throw new RuntimeException("Username already exists");
        }
        User user=User.builder()
                .username(registerDTO.getUsername())
                .password(passwordEncoder.encode(registerDTO.getPassword()))
                .role(Role.valueOf(registerDTO.getRole()))
                .build();
        userRepository.save(user);
        return "User registered successfully";
    }
}