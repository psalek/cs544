package cs544.exercise11_3;

import java.util.*;

public class BookService implements IBookService {
	public List<IBookSupplier> suppliers = new ArrayList<IBookSupplier>();

	public BookService() {
		IBookSupplier amazon = new Amazon();
		IBookSupplier barnesandnoble = new BarnesAndNoble();
		IBookSupplier ebooks = new EBooks();

		suppliers.add(amazon);
		suppliers.add(barnesandnoble);
		suppliers.add(ebooks);
	}

	public void buy(Book book) {
		double lowestPrice = 0;
		IBookSupplier cheapestSupplier = null;
		// find the cheapest supplier
		for (IBookSupplier supplier : suppliers) {
			double price = supplier.computePrice(book.getIsbn());
			if (cheapestSupplier == null) {
				cheapestSupplier = supplier;
				lowestPrice = price;
			} else {
				if (price < lowestPrice) {
					cheapestSupplier = supplier;
					lowestPrice = price;
				}
			}
		}
		// buy with the cheapest supplier
		if (cheapestSupplier != null) {
			cheapestSupplier.order(book);
		}

	}
}