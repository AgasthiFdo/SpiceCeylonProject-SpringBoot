package lk.ijse.aad.spice_ceylon_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthDTO {
    private String email;
    private String token;
}
