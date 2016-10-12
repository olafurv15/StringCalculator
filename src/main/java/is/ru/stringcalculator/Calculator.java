package is.ru.stringcalculator;

import java.util.ArrayList;

public class Calculator {

	public static int add(String text){

		checkNegativeNumb(text);

		if(text.equals("")){
			return 0;
		}
		else if(text.contains(",")){
			return sum(splitNumbers(text));
		}
		else
			return 1;
	}

	private static int toInt(String text) {
		return Integer.parseInt(text);
	}

	private static String toString(Integer number) {
		return Integer.toString(number);
	}

	private static String[] splitNumbers(String numbers) {
		numbers = numbers.replace("\n", ",");
		return numbers.split(",");
	}

	private static int sum(String[] numbers){
		int total = 0;

		for(String number : numbers) {
			total += toInt(number);
		}

		return total;
	}

	private static void checkNegativeNumb(String text) {
		if(text.equals(""))
			return;

		String[] numbers = splitNumbers(text);
		ArrayList<Integer> negNumbers = new ArrayList<Integer>();
		int checkNumb = 0;
		int counter = 0;
		String result = "";

		for(String number : numbers) {
			checkNumb = toInt(number);

			if(checkNumb < 0) {
				negNumbers.add(checkNumb);
				counter++;
			}
		}

		if(negNumbers.size() != 0) {
			int i = 0;
			for(Integer numb : negNumbers) {
				result += toString(numb);
				if( i != counter-1)
					result += ", ";
				i++;
			}

			throw new IllegalArgumentException("Negatives not allowed: " + result);
		}
 	}
}