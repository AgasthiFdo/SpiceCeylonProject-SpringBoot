package lk.ijse.aad.spice_ceylon_backend.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MerchantDTO {
    private Long id;
    private String name;
    private String phone;
    private String address;
    private String category;
}
