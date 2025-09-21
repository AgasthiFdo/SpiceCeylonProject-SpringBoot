package lk.ijse.aad.spice_ceylon_backend.entity;



import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "merchants")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;
    private String address;
    private String category;
}
