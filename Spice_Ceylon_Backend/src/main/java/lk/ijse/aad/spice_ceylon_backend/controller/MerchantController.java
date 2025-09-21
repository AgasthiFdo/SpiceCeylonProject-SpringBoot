package lk.ijse.aad.spice_ceylon_backend.controller;


import lk.ijse.aad.spice_ceylon_backend.dto.MerchantDTO;
import lk.ijse.aad.spice_ceylon_backend.service.MerchantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/merchants")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5500") // Frontend HTML run karana port ekata match karanna
public class MerchantController {

    private final MerchantService merchantService;

    @PostMapping
    public MerchantDTO createMerchant(@RequestBody MerchantDTO dto) {
        return merchantService.saveMerchant(dto);
    }

    @GetMapping
    public List<MerchantDTO> getAllMerchants() {
        return merchantService.getAllMerchants();
    }

    @GetMapping("/{id}")
    public MerchantDTO getMerchantById(@PathVariable Long id) {
        return merchantService.getMerchantById(id);
    }

    @PutMapping("/{id}")
    public MerchantDTO updateMerchant(@PathVariable Long id, @RequestBody MerchantDTO dto) {
        return merchantService.updateMerchant(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteMerchant(@PathVariable Long id) {
        merchantService.deleteMerchant(id);
    }
}
