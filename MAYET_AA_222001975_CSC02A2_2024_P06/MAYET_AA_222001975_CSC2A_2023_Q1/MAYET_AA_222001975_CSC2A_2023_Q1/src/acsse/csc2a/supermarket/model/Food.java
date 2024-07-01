package acsse.csc2a.supermarket.model;

public abstract class Food {
	
	private String Barcode;
	private String Quality;
	
	/**
	 * @param barcode
	 * @param quality
	 */
	public Food(String barcode, String quality) {
		Barcode = barcode;
		Quality = quality;
	}
	
	@Override
	public String toString() {
		return String.format("Barcode: %s\nQuality: %s", Barcode, Quality);
	}
	

	/**
	 * @return
	 */
	public String getBarcode() {
		return Barcode;
	}

	/**
	 * @param barcode
	 */
	public void setBarcode(String barcode) {
		Barcode = barcode;
	}

	/**
	 * @return
	 */
	public String getQuality() {
		return Quality;
	}
	
	/**
	 * @param quality
	 */
	public void setQuality(String quality) {
		Quality = quality;
	}

}
