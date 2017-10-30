package cs544.exercise11_3;

public interface IBookSupplier {
	public double computePrice(String isbn);
	public void order(Book book);
}
