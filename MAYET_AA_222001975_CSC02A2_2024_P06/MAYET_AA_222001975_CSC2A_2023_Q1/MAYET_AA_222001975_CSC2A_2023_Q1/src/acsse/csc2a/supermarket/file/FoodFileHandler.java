package acsse.csc2a.supermarket.file;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import acsse.csc2a.supermarket.model.CannedFood;
import acsse.csc2a.supermarket.model.EDietType;
import acsse.csc2a.supermarket.model.FrozenFood;
import acsse.csc2a.supermarket.model.Store;

public class FoodFileHandler
{
	public static Store readStore(String fileName)
	{
		Store store = new Store();
		
		try
		{
			File handlerFile = new File(fileName);
			try (Scanner txtOut = new Scanner(handlerFile)) {
				while (txtOut.hasNext())
				{
					String lineString = txtOut.nextLine();
					
					// [A-Z]{4}[/d]{2}[A-Z]{2}/t[./*]/t[/d][.][/d]
					//[A-Z]{4}\d{2}[A-Z]{2}\t\w+\t\d+\.\d+
					String regEx_CannedFoodString = "[A-Z]{4}\\d{2}[A-Z]{2}\\t\\w+\\t\\d+\\.\\d+";

					/* [A-Z]{4}[/d]{2}[A-Z]{2}/t[./*]
					 *	/t([VEGETARIAN|LACTOFREE|MEAT|VEGAN])/t[/d]
					 */
					////[A-Z]{4}\d{2}[A-Z]{2}\t\w+\t(VEGETARIAN|LACTOFREE|MEAT|VEGAN)\t\-\d+
					String regEx_FrozenFoodString = "[A-Z]{4}\\d{2}[A-Z]{2}\\t\\w+\\t(VEGETARIAN|LACTOFREE|MEAT|VEGAN)\\t\\-\\d+";

					Pattern regEx_CannedFoodPattern = Pattern.compile(regEx_CannedFoodString);
					Matcher regEx_CannedFoodMatch = regEx_CannedFoodPattern.matcher(lineString);
					
					Pattern regEx_FrozenFoodPattern = Pattern.compile(regEx_FrozenFoodString);
					Matcher regEx_FrozenFoodMatch = regEx_FrozenFoodPattern.matcher(lineString);
					
					StringTokenizer tokenizer = new StringTokenizer(lineString, "\t");
					
					if(regEx_CannedFoodMatch.matches())
					{
						String barcodeString = tokenizer.nextToken();
						String qualityString = tokenizer.nextToken();
						double weight = Double.parseDouble(tokenizer.nextToken());
						
						CannedFood cannedFood = new CannedFood(barcodeString, 
								qualityString, weight);
						store.AddToFoods(cannedFood);
						
					}else if(regEx_FrozenFoodMatch.matches())
					{
						String barcodeString = tokenizer.nextToken();
						String qualityString = tokenizer.nextToken();
						EDietType dietType = EDietType.valueOf(tokenizer.nextToken());
						int temp = Integer.parseInt(tokenizer.nextToken());
						
						FrozenFood frozenFood = new FrozenFood(barcodeString, 
								qualityString, temp, dietType);
						store.AddToFoods(frozenFood);
						
					}else {
						System.err.println("INVALID REGEX! COULD NOT READ LINE.");
					}
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return store;
	}
}
