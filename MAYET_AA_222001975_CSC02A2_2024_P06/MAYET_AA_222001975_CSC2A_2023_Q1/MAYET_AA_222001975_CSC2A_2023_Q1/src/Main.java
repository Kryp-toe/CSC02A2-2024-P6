import java.util.ArrayList;
import acsse.csc2a.supermarket.file.FoodFileHandler;
import acsse.csc2a.supermarket.model.*;

public class Main {
	public static void main(String[] args) {
		String [] fileStrings = {"data/supermarket-small.txt",
		 "data/supermarket-medium.txt","data/supermarket-large.txt"};
		
		ArrayList<Store> stores = new ArrayList<Store>();
		
		for (String file : fileStrings)
		{
			System.out.println("READING FROM: " + file);
			
			Store store = FoodFileHandler.readStore(file);
			
			if(store != null)
			{
				stores.add(store);
			}
			
		}
		
		System.out.println();
		String cannedString = "";
		String frozenString = "";
		
		if(stores != null)
		{
			for (Store s : stores)
			{
				ArrayList<Food> tempFoods = s.GetList();
				
				if (tempFoods != null)
				{
					for (Food f : tempFoods)
					{
						if(f instanceof CannedFood)
						{
							cannedString += f + "\n \n";
						}else if(f instanceof FrozenFood)
						{
							frozenString += f + "\n \n";
						}
					}
				}
			}
		}
		System.out.println("******************************************************* # CANNED FOOD # ********************************************************");
		System.out.println(cannedString);
		System.out.println();
		System.out.println("******************************************************* # FROZEN FOOD # ********************************************************");
		System.err.println(frozenString);
		
	}
}
