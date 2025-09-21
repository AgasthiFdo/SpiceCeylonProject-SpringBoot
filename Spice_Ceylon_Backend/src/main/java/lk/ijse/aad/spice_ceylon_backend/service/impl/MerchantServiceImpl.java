package lk.ijse.aad.spice_ceylon_backend.service.impl;


import lk.ijse.aad.spice_ceylon_backend.repository.MerchantRepository;
import lk.ijse.aad.spice_ceylon_backend.service.MerchantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MerchantServiceImpl implements MerchantService {

    private final MerchantRepository merchantRepository;

    @Override
    public MerchantDTO saveMerchant(MerchantDTO dto) {
        Merchant merchant = Merchant.builder()
                .name(dto.getName())
                .phone(dto.getPhone())
                .address(dto.getAddress())
                .category(dto.getCategory())
                .build();

        Merchant saved = merchantRepository.save(merchant);
        return mapToDTO(saved);
    }

    @Override
    public MerchantDTO updateMerchant(Long id, MerchantDTO dto) {
        Merchant merchant = merchantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Merchant not found"));

        merchant.setName(dto.getName());
        merchant.setPhone(dto.getPhone());
        merchant.setAddress(dto.getAddress());
        merchant.setCategory(dto.getCategory());

        Merchant updated = merchantRepository.save(merchant);
        return mapToDTO(updated);
    }

    @Override
    public void deleteMerchant(Long id) {
        merchantRepository.deleteById(id);
    }

    @Override
    public List<MerchantDTO> getAllMerchants() {
        return merchantRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MerchantDTO getMerchantById(Long id) {
        return merchantRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new RuntimeException("Merchant not found"));
    }

    private MerchantDTO mapToDTO(Merchant merchant) {
        return MerchantDTO.builder()
                .id(merchant.getId())
                .name(merchant.getName())
                .phone(merchant.getPhone())
                .address(merchant.getAddress())
                .category(merchant.getCategory())
                .build();
    }
}
