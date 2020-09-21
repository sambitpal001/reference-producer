package com.producer.service;


import com.producer.entity.Inventory;
import org.springframework.stereotype.Service;

/**
 * The Class InventoryService.
 */
@Service
public class InventoryService {
	
	
	public Inventory saveInventory(Inventory inventory){
		
		/* for testing the provider end. This service will be mocked */
		return new Inventory("TV", "CHENNAI", 100);
	}

}