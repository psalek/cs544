package cs544.exercise25_1.client;

import org.springframework.web.client.RestTemplate;

import cs544.exercise25_1.generated.shoppingList.Item;
import cs544.exercise25_1.generated.shoppingList.ShoppingList;
import cs544.exercise25_1.service.IShoppingListService;

public class ShopListServiceProxy implements IShoppingListService {
	private static final String listURL = "http://localhost:8080/exercise25_1-service/rest/list";
	private static final String itemURL = "http://localhost:8080/exercise25_1-service/rest/item/{product}";

	private RestTemplate restTemplate;
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public void addToList(Item item) {
		restTemplate.postForLocation(listURL, item);
	}
	
	public Item getItem(String product) {
		return restTemplate.getForObject(itemURL, Item.class, product);
	}

	public ShoppingList getList() {
		return restTemplate.getForObject(listURL, ShoppingList.class);
	}

	public void removeFromList(String product) {
		restTemplate.delete(itemURL, product);
	}

	public void updateItem(Item item) {
		restTemplate.put(itemURL, item, item.getProduct());
	}

}
