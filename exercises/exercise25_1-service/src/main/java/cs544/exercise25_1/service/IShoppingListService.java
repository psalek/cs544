package cs544.exercise25_1.service;

import cs544.exercise25_1.generated.shoppingList.Item;
import cs544.exercise25_1.generated.shoppingList.ShoppingList;

public interface IShoppingListService {

	public ShoppingList getList();

	public Item getItem(String product);

	public void addToList(Item item);

	public void removeFromList(String product);

	public void updateItem(Item item);

}