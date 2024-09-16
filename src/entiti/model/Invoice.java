package entiti.model;

public class Invoice {
	private double basicPaymen;
	private double tax;
	
	
	public Invoice() {
		super();
	}

	public Invoice(double basicPaymen, double tax) {
		super();
		this.basicPaymen = basicPaymen;
		this.tax = tax;

	}

	public double getBasicPaymen() {
		return basicPaymen;
	}

	public void setBasicPaymen(double basicPaymen) {
		this.basicPaymen = basicPaymen;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}
	
	public Double getTotalPayment() {
		return   getBasicPaymen() + getTax();
	}

	
}
