import java.util.Arrays;
import java.util.Comparator;

// ─────────────────────────────────────────────
// Exercise 6: Library Management
// Linear Search O(n) | Binary Search O(log n)
// ─────────────────────────────────────────────

public class Exercise6_LibraryManagement {

    static class Book {
        int    bookId;
        String title;
        String author;

        Book(int bookId, String title, String author) {
            this.bookId = bookId;
            this.title  = title;
            this.author = author;
        }

        @Override
        public String toString() {
            return String.format("Book[id=%d, title=\"%s\", author=%s]", bookId, title, author);
        }
    }

    static Book linearSearchByTitle(Book[] books, String title) {
        for (Book b : books)
            if (b.title.equalsIgnoreCase(title)) return b;
        return null;
    }

    static Book binarySearchByTitle(Book[] sorted, String title) {
        int low = 0, high = sorted.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = sorted[mid].title.compareToIgnoreCase(title);
            if      (cmp == 0) return sorted[mid];
            else if (cmp < 0)  low  = mid + 1;
            else               high = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] catalog = {
            new Book(1, "The Pragmatic Programmer",   "Hunt & Thomas"),
            new Book(2, "Clean Code",                 "Robert C. Martin"),
            new Book(3, "Introduction to Algorithms", "CLRS"),
            new Book(4, "Design Patterns",            "Gang of Four"),
            new Book(5, "Effective Java",             "Joshua Bloch"),
        };

        System.out.println("=== Linear Search ===");
        Book r = linearSearchByTitle(catalog, "Clean Code");
        System.out.println(r != null ? "Found: " + r : "Not Found");
        r = linearSearchByTitle(catalog, "SICP");
        System.out.println(r != null ? "Found: " + r : "Not Found (SICP)");

        Book[] sorted = Arrays.copyOf(catalog, catalog.length);
        Arrays.sort(sorted, Comparator.comparing(b -> b.title.toLowerCase()));

        System.out.println("\n=== Binary Search (sorted) ===");
        r = binarySearchByTitle(sorted, "Effective Java");
        System.out.println(r != null ? "Found: " + r : "Not Found");
        r = binarySearchByTitle(sorted, "SICP");
        System.out.println(r != null ? "Found: " + r : "Not Found (SICP)");

        System.out.println("\n--- Complexity ---");
        System.out.println("Linear : O(n)     — unsorted ok");
        System.out.println("Binary : O(log n) — must be sorted");
    }
}