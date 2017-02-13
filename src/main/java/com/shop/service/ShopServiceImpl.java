package com.shop.service;

import org.springframework.stereotype.Service;

import com.shop.model.Shop;
import com.shop.utils.DistanceCalculator;
import com.shop.utils.LatLongUtil;

@Service
public class ShopServiceImpl implements ShopService {
	
	Shop[] shopsArray = new Shop[10];
	int cnt = 0;
	
	public void addShops(Shop shop) {
		try {
			String[] latLong = LatLongUtil.getLatLongPositions(shop.getAddr().getPostCode());
			shop.setLatitude(latLong[0]);
			shop.setLongitude(latLong[1]);
			System.out.println(latLong[0]+ "::"+ latLong[1]);
			if(cnt != 10){
				shopsArray[cnt++] = shop;
			}else{
				throw new Exception("Array size full: "+cnt);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Shop getNearbyShops(String latitude, String longitude) {
		
			Double shortDistance = Double.MAX_VALUE;
			Shop nearestShop = null;
			for (Shop shop : shopsArray) {
				if(shop!=null){
					Double distance = DistanceCalculator.distance(Double.parseDouble(shop.getLatitude()), Double.parseDouble(shop.getLongitude()), Double.parseDouble(latitude), Double.parseDouble(longitude));
					if(shortDistance.compareTo(distance) > 0){
						shortDistance = distance;
						nearestShop = shop;
					}
				}
			}
			return nearestShop;
		}
	 
}
