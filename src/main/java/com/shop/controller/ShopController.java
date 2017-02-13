package com.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.shop.model.Shop;
import com.shop.service.ShopServiceImpl;

@RestController
public class ShopController {
		
		@Autowired
		ShopServiceImpl shopService;
		
		@PostMapping(value="/addShop", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public void addShop(@RequestBody Shop shop){
			shopService.addShops(shop);
		}
		
		@GetMapping(value="/getAddress")
		public Shop getAddress(@RequestParam("latitude") String latitude, @RequestParam("longitude") String longitude ){
			Shop shops = shopService.getNearbyShops(latitude,longitude);
			return shops;
		}
}
