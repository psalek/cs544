package cs544.exercise11_3;

public class EBooks implements IBookSupplier {
	public double computePrice(String isbn) {
		double price = Math.random() * 45;
		System.out.println("EBooks charges $" + price + " for book with isbn "
				+ isbn);
		return price;
	}

	public void order(Book book) {
		System.out.println("Book with isbn = " + book.getIsbn()
				+ " is ordered from EBooks");
	}
}
