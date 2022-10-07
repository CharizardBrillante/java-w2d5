package catalogue;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import tools.Randomizer;
import tools.Reader;

public class Catalogue {

	public static void main(String[] args) {
		
		//instance of catalogue
		ArrayList<AbstractBook> catalogue = new ArrayList<AbstractBook>();
		ArrayList<Book> books = new ArrayList<Book>();

		//fill catalogue
		for (int i = 0; i < 100; i++) {
			Book book = Randomizer.randomBook();
			books.add(book);
			catalogue.add(book);
			catalogue.add(Randomizer.randomMagazine());
		}
		
		System.out.println(catalogue);
		
		//write catalogue on txt
		File file = new File("catalogue.txt");
		
		try (FileWriter writer = new FileWriter(file)){			
			for(AbstractBook b: catalogue) {
				writer.write(b + System.lineSeparator());
				writer.flush();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		//read catalogue from txt
		try {
			Reader.readFile(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Scanner scanner = new Scanner(System.in);
		boolean logged = true;
		
		//USER INTERFACE
		while(logged) {
			System.out.println("Per cercare un libro digita 'search', \nper aggiungere un libro digita 'add', \nper rimuovere un libro digita 'delete'\n per uscire digita 'exit'");
			
			switch (scanner.nextLine()) {
				case "search":
					System.out.println("Per cercare per ISBN digita 'isbn', \nper cercare per anno di pubblicazione digita 'year', \nper cercare per autore digita 'author'");
					switch (scanner.nextLine()) {
						case "isbn":
							System.out.println("Digita l'ISBN");
							long isbn = Long.parseLong(scanner.nextLine());
							System.out.println(searchByIsbn(catalogue, isbn));
							continue;
						case "year":
							System.out.println("Digita l'anno di pubblicazione");
							int year = Integer.parseInt(scanner.nextLine());
							System.out.println(searchByYear(catalogue, year));
							continue;
						case "author":
							System.out.println("Digita il nome dell'autore");
							String author = scanner.nextLine();
							System.out.println(searchByAuthor(books, author));
							continue;
						default:
							continue;
					}
				case "add":
					System.out.println("Vuoi aggiungere un libro o una rivista?\nNe inserirò una random, perché non ho voglia di chiederti i dati");
					switch (scanner.nextLine()) {
						case "libro":
							Book book = Randomizer.randomBook();
							catalogue.add(book);
							books.add(book);
							System.out.println("Libro aggiunto! " + book);
							continue;
						case "rivista":
							Magazine magazine = Randomizer.randomMagazine();
							catalogue.add(magazine);
							System.out.println("Libro aggiunto! " + magazine);
							continue;
					}

				case "delete":
					System.out.println("Digita l'ISBN del libro che vuoi rimuovere");
					long isbn = Long.parseLong(scanner.nextLine());
					catalogue.removeIf(b -> b.isbn == isbn);
					System.out.println("Libro rimosso!");
					continue;
				case "exit":
					System.out.println("Arrivederci!");
					logged = false;
					break;
				default:
					System.out.println("Comando errato");
			}
			
		}
		
		
		scanner.close();
		
	}
	

	
	static ArrayList<AbstractBook> searchByIsbn(ArrayList<AbstractBook> catalogue, long isbn){
		return (ArrayList<AbstractBook>) catalogue.stream()
				.filter(b -> b.isbn == isbn)
				.collect(Collectors.toList());
	}
	
	static ArrayList<AbstractBook> searchByYear(ArrayList<AbstractBook> catalogue, int year){
		return (ArrayList<AbstractBook>) catalogue.stream()
				.filter(b -> b.releaseYear == year)
				.collect(Collectors.toList());
	}
	
	static ArrayList<Book> searchByAuthor(ArrayList<Book> books, String author){
		return (ArrayList<Book>) books.stream()
				.filter(b -> author.equals(b.author))
				.collect(Collectors.toList());
	}

}
