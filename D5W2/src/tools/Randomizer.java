package tools;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import catalogue.Book;
import catalogue.Magazine;

public class Randomizer {

	private static String randomString() {
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = ThreadLocalRandom.current().nextInt(4, 9);
		Random random = new Random();
		
		return random.ints(leftLimit, rightLimit + 1)
				.limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
				.toString();		
	}
	
	private static String randomGenre() {
		String[] genres = new String[] {"Fantasy", "Horror", "Historical", "Romance", "Science Fiction"};
		return genres[ThreadLocalRandom.current().nextInt(0, 4)];
	}
	
	private static String randomPeriodicity() {
		String[] periodicities = new String[] {"Weekly", "Monthly", "Half-yearly"};
		return periodicities[ThreadLocalRandom.current().nextInt(0, 3)];
	}
	
	private static int randomYear() {
		return ThreadLocalRandom.current().nextInt(1970, 2023);
	}
	
	private static int randomPages() {
		return ThreadLocalRandom.current().nextInt(100, 501);
	}
	
	//------------------------- PUBLIC METHODS ---------------------------------
	public static Book randomBook() {
		return new Book(randomString(), randomGenre(), randomString(), randomYear(), randomPages());
	}
	
	public static Magazine randomMagazine() {
		return new Magazine(randomString(), randomYear(), randomPages(), randomPeriodicity());
	}
}
