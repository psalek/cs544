package cs544.exercise11_2;

public class App 
{
	public static void main(String[] args) {
		IProductService productService = new ProductService();

		Product product1 = productService.getProduct(423);
		if (product1 != null) {
			System.out.println(product1.toString());
		}
		Product product2 = productService.getProduct(239);
		if (product2 != null) {
			System.out.println(product2.toString());
		}

	}
}
