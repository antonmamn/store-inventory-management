package management.inventory.controller;

import management.inventory.model.Inventory;
import management.inventory.model.Response;
import management.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path="/inventory")
public class InventoryController {
    private final InventoryService inventoryService;
@Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping(path = "/getall")
    public ResponseEntity<List<Inventory>> getAllInventory(){
        List<Inventory> allInventory = inventoryService.getAllInventory();
        return ResponseEntity.ok(allInventory);
    }

    @GetMapping(path = "/getallbystoreid/{storeid}")
    public ResponseEntity<List<Inventory>> getAllInventoryByStoreId (@PathVariable("storeid") Long storeId) {
           List<Inventory> allInventoryByStoreId = inventoryService.getAllInventoryByStoreId(storeId);
             return ResponseEntity.ok(allInventoryByStoreId);
        }

    @GetMapping(path="/getbyid/{id}")
    public ResponseEntity<Inventory> getById(@PathVariable Long id){

        Inventory inv= inventoryService.getById(id);

    return ResponseEntity.ok(inv);
    }

    @PostMapping(path="/post")
    public ResponseEntity<Long> addNewInventory(@RequestBody Inventory inventory){
    Long id=inventoryService.addNewInventory(inventory);
    ResponseEntity<Long> response = ResponseEntity.ok(id);
    return response;
    }
@DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> deleteInventoryById  (@PathVariable Long id){
    inventoryService.deleteInventoryById(id);
    return ResponseEntity.ok().build();
}
@PutMapping(path = "/update")
    public ResponseEntity<?> updateInventory (Inventory inventory){
         inventoryService.updateInventory(inventory);
        return ResponseEntity.ok().build();
    }
}
