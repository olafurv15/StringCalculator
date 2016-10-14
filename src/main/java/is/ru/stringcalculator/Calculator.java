package is.ru.stringcalculator;

import java.util.ArrayList;

public class Calculator {

	public static int add(String text){

		if(isEmpty(text)){
			return 0;
		}
		else {
			String[] numbArray = splitNumbers(text);
			checkNegativeNumb(numbArray);
			return sum(numbArray);
		}
	}

	private static int toInt(String text) {
		return Integer.parseInt(text);
	}

	private static String toString(Integer number) {
		return Integer.toString(number);
	}

	private static String[] splitNumbers(String numbers) {
		if(numbers.contains("//")) {
			String [] splitNumbers = numbers.split("//");
			String delimiter = splitNumbers[1].substring(0,1);
			numbers = splitNumbers[1].substring(2);

			return numbers.split(delimiter);
		}
		else {
			numbers = numbers.replace("\n", ",");
			return numbers.split(",");
		}
	}

	private static int sum(String[] numbers){
		int total = 0;
		int numb = 0;

		for(String number : numbers) {
			numb = toInt(number);

			if(numb <= 1000)
				total += numb;
		}

		return total;
	}

	private static boolean isEmpty(String text) {
		if(text.equals("")) {
			return true;
		}
		else {
			return false;
		}
	}

	private static void checkNegativeNumb(String[] numbers) throws IllegalArgumentException {
		ArrayList<Integer> negNumbers = new ArrayList<Integer>();
		int checkNumb = 0;
		String result = "";

		for(String number : numbers) {
			checkNumb = toInt(number);

			if(checkNumb < 0) {
				negNumbers.add(checkNumb);
			}
		}

		if(negNumbers.size() != 0) {
			int counter = 0;
			for(Integer numb : negNumbers) {
				result += toString(numb);
				if( counter != negNumbers.size() - 1)
					result += ", ";
				counter++;
			}

			throw new IllegalArgumentException("Negatives not allowed: " + result);
		}
 	}
}