package lk.ijse.aad.spice_ceylon_backend.repository;


import lk.ijse.aad.spice_ceylon_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {


  User findByEmail(String email); // Find user by email
  boolean existsByEmail(String email);

  @Query(value = "SELECT * FROM User  LIMIT :limit OFFSET :offset", nativeQuery = true)
  List<User> findUserPaginated(@Param("limit") int limit, @Param("offset") int offset);

  @Query(value = "SELECT COUNT(*) FROM user ", nativeQuery = true)
  int getTotalUserCount();


//  List<User> findUserByUsernameContainingIgnoreCase(String keyword);
}


