public class LibraryTest {
    public static void main(String[] args) {
        // Sorted alphabetically for binary search
        Book[] books = {
            new Book(2, "Crime and Punishment", "Fyodor Dostoevsky"),
            new Book(1, "The Metamorphosis", "Franz Kafka"),
            new Book(3, "The Stranger", "Albert Camus")
        };

        int i1 = LibrarySearch.linearSearch(books, "The Metamorphosis");
        System.out.println("Linear Search - The Metamorphosis: index " + i1);

        int i2 = LibrarySearch.binarySearch(books, "Crime and Punishment");
        System.out.println("Binary Search - Crime and Punishment: index " + i2);

        int i3 = LibrarySearch.binarySearch(books, "The Stranger");
        System.out.println("Binary Search -The Stranger: index " + i3);
    }
}