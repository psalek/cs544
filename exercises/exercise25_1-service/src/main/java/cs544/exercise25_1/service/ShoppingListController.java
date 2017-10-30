package cs544.exercise25_1.service;

import cs544.exercise25_1.generated.shoppingList.Item;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ShoppingListController {

	private IShoppingListService shoppingListService;
	
	public void setShoppingListService(IShoppingListService shoppingListService) {
		this.shoppingListService = shoppingListService;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("marshalview");
		
		mav.addObject("list", shoppingListService.getList());
		return mav;
	}

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public RedirectView addItem(@RequestBody Item item) {

		shoppingListService.addToList(item);
		return new RedirectView("list");
	}

	@RequestMapping(value = "/item/{product}*", method = RequestMethod.GET)
	public ModelAndView item(@PathVariable("product") String product) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("item");
		
		Item item = shoppingListService.getItem(product);
		if (item != null) {
			mav.addObject("item", item);
		}
		return mav;
	}

	@RequestMapping(value = "/item/{product}", method = RequestMethod.PUT)
	public RedirectView updateItem(@RequestBody Item item) {

		shoppingListService.updateItem(item);
		return new RedirectView(item.getProduct());
	}

	@RequestMapping(value = "/item/{product}", method = RequestMethod.DELETE)
	public RedirectView deleteItem(@PathVariable("product") String product) {
		
		shoppingListService.removeFromList(product);
		return new RedirectView("../list");
	}

}
