package lesson9.prob1.business;

import java.util.*;
import java.util.stream.Collectors;

import lesson9.prob1.dataaccess.DataAccess;
import lesson9.prob1.dataaccess.DataAccessFacade;
import lesson9.prob1.business.Book;
import lesson9.prob1.business.LibraryMember;

public class Main {

	public static void main(String[] args) {
		System.out.println(allWhoseZipContains3());
		System.out.println(allHavingAtLeastTwoCopies());
		System.out.println(allHavingMultipleAuthors());
	}
	//Returns a list of all ids of LibraryMembers whose zipcode contains the digit 3
	public static List<String> allWhoseZipContains3() {
		/*
		 * DataAccess da = new DataAccessFacade(); Collection<LibraryMember> members =
		 * da.readMemberMap().values(); List<LibraryMember> mems = new ArrayList<>();
		 * mems.addAll(members);
		 */
		//implement
		return new DataAccessFacade().readMemberMap().values().stream()
				.filter(m -> m.getAddress().getZip().contains(""+3))
				.map(LibraryMember::getMemberId)
				.collect(Collectors.toList());
		
		
		
	}
	//Returns a list of all isbns of books having at least two copies
	public static List<String> allHavingAtLeastTwoCopies() {
		/*
		 * DataAccess da = new DataAccessFacade(); Collection<Book> books =
		 * da.readBooksMap().values(); List<Book> bs = new ArrayList<>();
		 * bs.addAll(books);
		 */
		//implement
		return new DataAccessFacade().readBooksMap().values().stream()
				.filter(c -> c.getCopies().length >= 2)
				.map(Book::getIsbn)
				.collect(Collectors.toList());
		
	}

	//Returns a list of all isbns of  Books that have multiple authors
	public static List<String> allHavingMultipleAuthors() {
		/*
		 * DataAccess da = new DataAccessFacade(); Collection<Book> books =
		 * da.readBooksMap().values(); List<Book> bs = new ArrayList<>();
		 * bs.addAll(books);
		 */
		//implement
		return new DataAccessFacade().readBooksMap().values().stream()
				.filter(c -> c.getAuthors().size() >1)
				.map(Book::getIsbn)
				.collect(Collectors.toList());
		
		}

}
