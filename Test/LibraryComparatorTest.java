import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class LibraryComparatorTest {
    @Test
    void creatorComparatorSortsByCreatorAndTitle(){
        var book1 = new Book("9781492072508", "Think Java", "Allan B. Downey", 326);
        var book2 = new Book("9788763851664", "Omrids", "Rachel Cusk", 256);
        var book3 = new Book("9780062316097", "Sapiens", "Yuval Noah Harari", 466);

    var books = new ArrayList<Resource>(List.of(book3,book1,book2));
    books.sort(new ResourceCreatorComparator());

    assertEquals(List.of(book1,book2,book3), books);
    }

    @Test
    void creatorComparatorUsesTitleInsteadOfCreator(){
        var oppenheimer = new Movie ("12345689", "Oppenheimer", "Christopher Nolan", 180);
        var interstellar = new Movie("1234456777", "Interstellar", "Christopher Nolan", 169);
        var movies = new ArrayList<Resource>(List.of (oppenheimer,interstellar));

        movies.sort(new ResourceCreatorComparator());

        assertEquals(List.of(interstellar,oppenheimer), movies);
    }

    //Dansk Alfabet
    @Test
    void creatorComparatorDanishAlphabet(){
        var aa = new Book ("1111", "Bog 1", "Åge Ågensen", 100);
        var ae = new Book ("2222", "Bog 2", "Ægir Ægensen", 100);
        var oe = new Book ("3333", "Bog 3", "Øivind Øivindsen", 100);

        var books = new ArrayList<Resource>(List.of(aa, ae, oe));
        books.sort(new ResourceCreatorComparator(Locale.of("da")));

        assertEquals(List.of(ae, oe, aa), books);
    }

    //Svensk Alfabet
    @Test
    void creatorComparatorSwedishAlphabet(){
        var oe = new Book ("1111", "Bog 1", "Öivind Öivindsen", 100);
        var ae = new Book ("2222", "Bog 2", "Ägir Ägensen", 100);
        var aa = new Book ("3333", "Bog 3", "Åge Ågensen", 100);

        var books = new ArrayList<Resource>(List.of(oe, ae, aa));
        books.sort(new ResourceCreatorComparator(Locale.of("sv")));

        assertEquals(List.of(aa, ae, oe), books);
    }

    @Test
    void loanBorrowDateComparatorSortsByBorrowDate() {
        var member = new Member("Daniel", 1234);
        var book = new Book("1", "Think Java", "Allan B. Downey", 326);
        var loan1 = new Loan(member, book, LocalDate.of(2026, 1, 1), LocalDate.of(2026, 1, 31));
        var loan2 = new Loan(member, book, LocalDate.of(2026, 3, 1), LocalDate.of(2026, 3, 15));

        var loans = new ArrayList<>(List.of(loan2, loan1));
        loans.sort(new LoanBorrowdateComparator());

        assertEquals(List.of(loan1, loan2), loans);
    }

    @Test
    void loansOrderIsDueDate() {
        var member = new Member("Daniel", 1234);
        var book = new Book("1", "Think Java", "Allan B. Downey", 326); //lånes først, så har en anden due date
        var Late = new Loan(member, book, LocalDate.of(2026, 1, 1), LocalDate.of(2026, 2, 28));
        var Early = new Loan(member, book, LocalDate.of(2026, 1, 10), LocalDate.of(2026, 1, 24));

        var loans = new ArrayList<>(List.of(Late, Early));
        loans.sort(null);

        assertEquals(List.of(Early, Late), loans);
    }

    @Test
    void memberOrderIsId() {
        var tobias = new Member("tobias", 9999);
        var chris = new Member("chris", 1212);
        var daniel = new Member("Daniel", 1234);

        var members = new ArrayList<>(List.of(tobias, daniel, chris));
        members.sort(null);

        assertEquals(List.of(chris, daniel, tobias), members);
    }
    @Test
    void resourcesOrderByIdentifier() {
        var game = new VideoGame("2801234567855", "Call of Duty: Black Ops 2", "Activision");
        var movie = new Movie("5701234567890", "Interstellar", "Christopher Nolan", 169);
        var book = new Book("9781492072508", "Think Java", "Allan B. Downey", 326);

        var resources = new ArrayList<Resource>(List.of(book, game, movie));
        resources.sort(null);

        assertEquals(List.of(game, movie, book), resources);
    }




}