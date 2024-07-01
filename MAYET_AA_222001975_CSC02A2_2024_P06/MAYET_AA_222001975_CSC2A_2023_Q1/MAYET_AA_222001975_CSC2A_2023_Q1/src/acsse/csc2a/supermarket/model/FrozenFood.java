package acsse.csc2a.supermarket.model;

public class FrozenFood extends Food{
	
	/**
	 * 
	 */
	private int Temp;
	private EDietType Diet;
	
	public FrozenFood(String barcode, String quality, int temp, EDietType diet) {
		super(barcode, quality);
		Temp = temp;
		Diet = diet;
	}
	
	@Override
	public String toString() {
		return String.format("%s\nDietType: %s\nTemperature: %s", super.toString(), Diet, Temp);
	}

	public int getTemp() {
		return Temp;
	}

	public void setTemp(int temp) {
		Temp = temp;
	}

	public EDietType getDiet() {
		return Diet;
	}

	public void setDiet(EDietType diet) {
		Diet = diet;
	}
}
