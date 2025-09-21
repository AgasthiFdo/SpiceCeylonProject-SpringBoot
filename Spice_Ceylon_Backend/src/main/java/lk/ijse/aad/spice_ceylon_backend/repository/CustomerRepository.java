package lk.ijse.aad.spice_ceylon_backend.repository;


import lk.ijse.aad.spice_ceylon_backend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

