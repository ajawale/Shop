package com.shop.controller;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.shop.model.Address;
import com.shop.model.Shop;
import com.shop.service.ShopServiceImpl;

@RunWith(SpringRunner.class)
/*@WebMvcTest(ShopController.class)*/
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ShopControllerTest {
	
    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private ShopServiceImpl shopService;
    
    @Test
    public void testAddShops() throws Exception {
    	Address addr = new Address(1,"411037");
    	Shop shop = new Shop("Test2",addr,null,null);
        ResponseEntity t = this.restTemplate.postForEntity("/addShop", shop, HttpStatus.OK.getClass());
        
    }
    
    @Test
    public void testGetNearestShop(){
    	Address adr = new Address(1,"411037");
    	Shop shop = new Shop("Anup",adr,"42.3593665","-71.0883125");
    	shopService.addShops(shop);
    	ResponseEntity t = this.restTemplate.getForEntity("/getAddress?latitude=42.3593665&longitude=-71.0883125", MediaType.APPLICATION_JSON_UTF8_VALUE.getClass());
    	assertEquals(HttpStatus.OK,t.getStatusCode() );
    }

}
