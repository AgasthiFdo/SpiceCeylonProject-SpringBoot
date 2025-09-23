package lk.ijse.aad.spice_ceylon_backend.service.impl;


import lk.ijse.aad.spice_ceylon_backend.dto.CustomerDTO;
import lk.ijse.aad.spice_ceylon_backend.entity.Customer;
import lk.ijse.aad.spice_ceylon_backend.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repo;

    private CustomerDTO mapToDTO(Customer customer) {
        return new CustomerDTO(
                customer.getId(),
                customer.getName(),
                customer.getPhone(),
                customer.getAddress(),
                customer.getPayment()
        );
    }

    private Customer mapToEntity(CustomerDTO dto) {
        return new Customer(
                dto.getId(),
                dto.getName(),
                dto.getPhone(),
                dto.getAddress(),
                dto.getPayment()
        );
    }

    @Override
    public CustomerDTO saveCustomer(CustomerDTO dto) {
        Customer customer = repo.save(mapToEntity(dto));
        return mapToDTO(customer);
    }

    @Override
    public CustomerDTO updateCustomer(Long id, CustomerDTO dto) {
        Customer customer = repo.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
        customer.setName(dto.getName());
        customer.setPhone(dto.getPhone());
        customer.setAddress(dto.getAddress());
        customer.setPayment(dto.getPayment());
        return mapToDTO(repo.save(customer));
    }

    @Override
    public void deleteCustomer(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
        return repo.findById(id).map(this::mapToDTO).orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}
