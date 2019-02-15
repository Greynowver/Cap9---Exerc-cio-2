package application;

import java.text.ParseException;

import service.Register;

public class Program {

	public static void main(String[] args) throws ParseException {
	
		new Register().registerProducts();
	}

}
