package com.producer;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import au.com.dius.pact.provider.spring.SpringRestPactRunner;
import com.producer.entity.Inventory;
import com.producer.service.InventoryService;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import au.com.dius.pact.provider.junit.IgnoreNoPactsToVerify;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactBroker;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

/**
 * The Class InventoryProviderTest.
 */
@IgnoreNoPactsToVerify
@RunWith(SpringRestPactRunner.class)
@SpringBootTest(classes=PactContractProviderApplication.class,properties={"spring.profiles.active=test","spring.cloud.config.enabled=false"},webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
@PactBroker(host="ec2-15-207-223-119.ap-south-1.compute.amazonaws.com",port="8500")
@Provider("inventory_provider")
public class InventoryProviderTest {
	
	  @MockBean
	  private InventoryService inventoryService;

	  @TestTarget
	  public final Target target = new HttpTarget(8060);
  
	  @State(value="create inventory")
	  public void createInventoryState() throws Exception{

	      Inventory inventory=new Inventory("TV", "CHENNAI", 100);
	      when(inventoryService.saveInventory(any(Inventory.class))).thenReturn(inventory) ;
	  }
} 