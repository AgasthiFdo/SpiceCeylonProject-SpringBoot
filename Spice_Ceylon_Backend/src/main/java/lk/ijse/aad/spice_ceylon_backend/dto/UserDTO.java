package lk.ijse.aad.spice_ceylon_backend.dto;

import lk.ijse.aad.spice_ceylon_backend.entity.RoleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private Long id;
//    @NotBlank(message = "username is null")
    private String username;
//    @NotBlank(message = "email is null")
//    @Email(message = "invalid Email")
    private String email;
//    @NotBlank(message = "password is null")
    private String password;
    private RoleType role;
}
