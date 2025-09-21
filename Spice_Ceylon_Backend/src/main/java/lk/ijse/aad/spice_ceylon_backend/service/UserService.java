package lk.ijse.aad.spice_ceylon_backend.service;


//import lk.ijse.aad.spice_ceylon_backend.dto.PaymentDTO;
//import lk.ijse.aad.spice_ceylon_backend.dto.TraditionalItemDTO;
import lk.ijse.aad.spice_ceylon_backend.dto.UserDTO;
import lk.ijse.aad.spice_ceylon_backend.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {


    int addUser(UserDTO userDTO);

    UserDetails loadUserByUsername(String email);



    User findByEmail(String email);

    public List<UserDTO> getUsersForPage(int page, int size);

    public int getTotalPages(int size);

//    public List<UserDTO> searchUsers(String keyword);

    public List<UserDTO>searcherUsersByRole(String keyword);

    int getTotalUserCount();






}
