package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Register {

	public void registerProducts() throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Product> product = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int nProducts = sc.nextInt();
		
		for (int i = 1; i <= nProducts; i++) {
			System.out.println("Product #" + i + " data: ");
			System.out.print("Common, used or imported (c/u/i)? ");
			char typeProduct = sc.next().charAt(0);
			
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			
			if (typeProduct == 'c') {	
			  product.add(new Product(name, price));
			  }
			
			else if (typeProduct == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY)? ");
				Date date = sdf.parse(sc.next());
				product.add(new UsedProduct(name, price, date));
			}
			
			else if (typeProduct == 'i'){
				System.out.print("Customs fee: ");
				double customFee = sc.nextDouble();
				product.add(new ImportedProduct(name, price, customFee));
		
			}
			else {
				System.out.println("Invalid Awnser!");
			}
		}
	
		System.out.println("PRICE TAGS: ");
		for (Product p : product) {
			System.out.println(p.priceTag());
	
		}
		
		sc.close();
	}
	
}
