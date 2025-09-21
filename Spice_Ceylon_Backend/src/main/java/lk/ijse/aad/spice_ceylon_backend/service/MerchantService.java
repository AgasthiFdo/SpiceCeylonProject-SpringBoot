package lk.ijse.aad.spice_ceylon_backend.service;



import java.util.List;

public interface MerchantService {
    MerchantDTO saveMerchant(MerchantDTO dto);
    MerchantDTO updateMerchant(Long id, MerchantDTO dto);
    void deleteMerchant(Long id);
    List<MerchantDTO> getAllMerchants();
    MerchantDTO getMerchantById(Long id);
}
