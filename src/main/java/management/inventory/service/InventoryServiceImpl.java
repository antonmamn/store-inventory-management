package management.inventory.service;

import jakarta.transaction.Transactional;
import management.inventory.model.Inventory;
import management.inventory.model.InventoryStatus;
import management.inventory.repository.InventoryRepository;
import management.store.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService {

private final StoreService storeService;
    private final InventoryRepository inventoryRepository;
@Autowired
    public InventoryServiceImpl(@Qualifier("storeServiceImpl") StoreService storeService, InventoryRepository inventoryRepository) {
    this.storeService = storeService;
    this.inventoryRepository = inventoryRepository;
    }

    @Override
    public List<Inventory> getAllInventory() {
        List<Inventory> allInventory = inventoryRepository.findAll();
       if (allInventory.isEmpty()) {
           throw new RuntimeException("List is empty");
       } else {
           return allInventory;
       }
    }

    @Override
    public Inventory getById(Long id) {
        Optional <Inventory> inventory = inventoryRepository.findById(id);
        if (inventory.isPresent()){
            return inventory.get();
        }else{
            throw new RuntimeException("No inventory by this ID : "+id);
        }


    }
    @Override
    public List<Inventory> getAllInventoryByStoreId(Long storeId) {
        if (storeService.getStoreById(storeId)!=null) {
            List<Inventory> allByStoreId = inventoryRepository.findAllByStoreId(storeId);
            if (allByStoreId!=null){
                return allByStoreId;
            } else {
                throw new RuntimeException("NO INVENTORY IN THIS STOIRE");
            }
        }else {
            throw new RuntimeException("STORE WITH THIS ID : "+storeId+" DOESN'T EXIST");
        }
     }
    @Transactional(rollbackOn = Exception.class)
    @Override
    public Long addNewInventory(Inventory inventory) {
        if (storeService.getStoreById(inventory.getStoreId())!=null) {
            return inventoryRepository.save(inventory).getId();
        }else {
            throw new RuntimeException("STORE WITH THIS ID : "+inventory.getStoreId()+" DOESN'T EXIST");
        }
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void deleteInventoryById(Long id) {
      Optional <Inventory> inventory = inventoryRepository.findById(id);
          if (inventory.isPresent()){
               inventoryRepository.updateStatusById(id, InventoryStatus.DAMAGED);
          }else{
              throw new RuntimeException("No inventory by this ID : "+id);
          }
    }
    @Transactional(rollbackOn = Exception.class)
    @Override
    public void updateInventory(Inventory inventory) {
        Optional <Inventory> optionalInventory = inventoryRepository.findById(inventory.getId());
        if (optionalInventory.isPresent()){
           inventoryRepository.save(inventory);
        }else{
            throw new RuntimeException("No optionalInventory by this ID : "+inventory.getId());
        }
    }
}
