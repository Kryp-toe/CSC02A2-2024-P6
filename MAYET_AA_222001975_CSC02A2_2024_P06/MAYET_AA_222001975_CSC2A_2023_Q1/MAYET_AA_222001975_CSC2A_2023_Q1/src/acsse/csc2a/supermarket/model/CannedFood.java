package acsse.csc2a.supermarket.model;

public class CannedFood extends Food{
	
	private double Weight;
	
	public CannedFood(String barcode, String quality, 
			double weight)
	{
		super(barcode, quality);
		Weight = weight;
	}
	
	@Override
	public String toString() {
		return String.format("%s\nWeight: %s", super.toString(), Weight);
	}

	public double getWeight() {
		return Weight;
	}

	public void setWeight(double weight) {
		Weight = weight;
	}
}
