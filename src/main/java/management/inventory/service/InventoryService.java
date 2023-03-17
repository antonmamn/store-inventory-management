package management.inventory.service;

import management.inventory.model.Inventory;

import java.util.List;

public interface InventoryService {
      List<Inventory> getAllInventory();
    Inventory getById(  Long id);
    Long addNewInventory( Inventory inventory);
    void deleteInventoryById  (Long id);
    void updateInventory (Inventory inventory);

    List<Inventory> getAllInventoryByStoreId(Long storeId);
}
