package management.inventory.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long storeId;
    private String equipmentName;
    private String serialNumber;
    private LocalDateTime lastCheckDate;
    private LocalDateTime nextCheckDate;

    private LocalDateTime insertedDate;
    private LocalDateTime updateDate;
    private LocalDateTime deleteDate;
    private String createUser;
    private String updateUser;
    private String deleteUser;
    private Integer status;

}
