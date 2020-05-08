package com.shop.controllers;

import com.shop.exception.ResourceNotFoundException;
import com.shop.model.Items;
import com.shop.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/items")
    public List<Items> getAllItems() {
        return itemRepository.findAll();
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<Items> getItemById(@PathVariable(value = "id") Long itemsId)
        throws ResourceNotFoundException{
        Items items = itemRepository.findById(itemsId)
                .orElseThrow(()-> new ResourceNotFoundException("there is no  item with this id="+itemsId));
        return ResponseEntity.ok().body(items);
    }

    @PostMapping("/items")
    public Items saveItem(@Valid @RequestBody Items items) {
        return itemRepository.save(items);
    }


        @PutMapping("/items/{id}")
        public ResponseEntity<Items> updateItemById(@PathVariable(value = "id") Long ItemId,
                                                    @Valid @RequestBody Items itemsDetails)
            throws ResourceNotFoundException{
            Items items = itemRepository.findById(ItemId)
                    .orElseThrow(()-> new ResourceNotFoundException("there is no  item with this id="+ItemId));
            items.setPrice(itemsDetails.getPrice());
            items.setQuantity(itemsDetails.getPrice());
            items.setSize(itemsDetails.getSize());
            final Items updatedItem=itemRepository.save(items);
            return ResponseEntity.ok(updatedItem);
        }


        @DeleteMapping("/items/{id}")
    public Map<String,Boolean> deleteItem(@PathVariable(value = "id") Long itemId)
            throws ResourceNotFoundException{
        Items items=itemRepository.findById(itemId)
                .orElseThrow(()-> new ResourceNotFoundException("this item is not found with this this id="+itemId));
        itemRepository.delete(items);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return  response;
        }






}
