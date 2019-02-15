package entities;

public class ImportedProduct extends Product {

	private Double customsFee;

	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}

	public Double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}
	
	public Double totalPrice() {
		return getPrice() + getCustomsFee();
	}
	
	@Override
	public String priceTag() {
		double soma = totalPrice();
		String dados = getName() + " $ " + soma + " (Customs fee: $ " + String.format("%.2f", getCustomsFee()) + ")";
		return dados;
	}
	
	
	
}
