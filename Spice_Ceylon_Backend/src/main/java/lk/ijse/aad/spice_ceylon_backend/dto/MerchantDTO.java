package lk.ijse.aad.spice_ceylon_backend.dto;



import lombok.*;

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
