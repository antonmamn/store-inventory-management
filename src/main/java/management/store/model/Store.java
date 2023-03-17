package management.store.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String storeName;
    private String address;
    private String city;
    private String phoneNumber;
    private String email;
    private LocalDateTime insertedDate;
    private LocalDateTime  updateDate;
    private LocalDateTime  deleteDate;
    private String  createUser;
    private String  updateUser;
    private String  deleteUser;
    private Integer status ;
}
