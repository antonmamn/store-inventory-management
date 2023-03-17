package management.inventory.repository;

import management.inventory.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface InventoryRepository extends JpaRepository<Inventory,Long> {
    @Modifying(clearAutomatically = true)
    @Query("update Inventory i set i.status= :status where i.id= :id")
    void updateStatusById(Long id,int status);

    List<Inventory> findAllByStoreId(Long storeId);
}
