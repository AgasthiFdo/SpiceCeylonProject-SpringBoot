package lk.ijse.aad.spice_ceylon_backend.controller;

import lombok.RequiredArgsConstructor;
import lk.ijse.aad.spice_ceylon_backend.dto.ApiResponse;
import lk.ijse.aad.spice_ceylon_backend.dto.AuthDTO;
import lk.ijse.aad.spice_ceylon_backend.dto.RegisterDTO;
import lk.ijse.aad.spice_ceylon_backend.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> registerUser(
            @RequestBody RegisterDTO registerDTO){
        return ResponseEntity.ok(
                new ApiResponse(
                        200,
                        "User registered successfully",
                        authService.register(registerDTO)
                )
        );
    }
    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody AuthDTO authDTO){
        return ResponseEntity.ok(new ApiResponse(200,
                "OK",authService.authenticate(authDTO)));
    }

}