package cs544.exercise25_1.client;

import cs544.exercise25_1.generated.shoppingList.Item;
import cs544.exercise25_1.service.IShoppingListService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ShopListApplication {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"springconfig.xml");
		IShoppingListService remoteService = context.getBean(
				"shopListServiceProxy", IShoppingListService.class);

		// create
		Item tomato = new Item("Tomatoes", 3, "Prefer Organic");
		Item avocado = new Item("Avocados", 3, "Organic or non-organic");
		remoteService.addToList(tomato);
		remoteService.addToList(avocado);
		System.out.println(remoteService.getList());

		// update
		tomato.setQty(5);
		remoteService.updateItem(tomato);
		System.out.println(remoteService.getList());

		// delete
		remoteService.removeFromList("Avocados");
		System.out.println(remoteService.getList());
	}
}
