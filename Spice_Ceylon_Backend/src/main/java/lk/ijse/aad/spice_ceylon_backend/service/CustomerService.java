package lk.ijse.aad.spice_ceylon_backend.service;


import lk.ijse.aad.spice_ceylon_backend.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    CustomerDTO saveCustomer(CustomerDTO dto);
    CustomerDTO updateCustomer(Long id, CustomerDTO dto);
    void deleteCustomer(Long id);
    List<CustomerDTO> getAllCustomers();
    CustomerDTO getCustomerById(Long id);
}
