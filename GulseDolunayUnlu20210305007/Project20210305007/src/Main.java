import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Kütüphane yöneticisini oluşturuyoruz
        LibraryManager<LibraryItem> manager = new LibraryManager<>();

        // Nesneleri oluşturuyoruz
        Book book1 = new Book("Book: Object-Oriented Programming", 1001, "A.Kilinc");
        Book book2 = new Book("Book: Murder on the Orient Express", 1002, "Agatha Christie");
        Book book3 = new Book("Book: On the Origin of Species", 1003, "Charles Darwin");
        Magazine mag1 = new Magazine("Magazine: Java Developer Trends", 2005, 50);
        Magazine mag2 = new Magazine("Magazine: National Geographic", 2006, 45);
        Magazine mag3 = new Magazine("Magazine: Software Engineering Journal", 2007, 1);

        // Nesneleri Yöneticinin koleksiyonuna ekleyelim
        manager.addItem(book1);
        manager.addItem(book2);
        manager.addItem(book3);
        manager.addItem(mag1);
        manager.addItem(mag2);
        manager.addItem(mag3);

        System.out.println("\n--- LIBRARY APPLICATION STARTED ---");

        boolean running = true;
        while (running) {

            // Menü Görüntüsü
            System.out.println("\n-------------------------------------------");
            System.out.println("1. Show ALL Items");
            System.out.println("2. Show ALL Books");
            System.out.println("3. Show ALL Magazines");
            System.out.println("4. Check Item by ID"); // <-- YENİ SEÇENEK
            System.out.println("5. Rent Book (Object-Oriented Programming)");
            System.out.println("6. Return Book (Object-Oriented Programming)");
            System.out.println("7. Exit"); // <-- Exit 7 oldu
            System.out.println("-------------------------------------------");
            System.out.print("Enter your choice: ");

            int choice = 0;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Yanlış girilirse döngü olmaması için
                continue;
            }

            // Seçime göre işlem yapma arayüzü
            switch (choice) {
                case 1:
                    manager.displayAllItems(); // Tüm koleksiyonu gösterir
                    System.out.println("Total items: " + manager.getTotalCount());
                    break;
                case 2:
                    // Lambda Fonksiyonu ile sadece adında book geçenleri filtreleme
                    List<LibraryItem> books = manager.filterItemsByTitle("Book");
                    System.out.println("\n** FILTERED: ALL BOOKS **");
                    books.forEach(item -> System.out.println(" -> " + item.toString()));
                    break;
                case 3:
                    // Lambda Fonksiyonu ile sadece adında magazine geçenleri filtreleme
                    List<LibraryItem> mags = manager.filterItemsByTitle("Magazine");
                    System.out.println("\n** FILTERED: ALL MAGAZINES **");
                    mags.forEach(item -> System.out.println(" -> " + item.toString()));
                    break;
                case 4: // Yeni Map Testi
                    System.out.print("\nEnter Item ID to search (e.g., 1002 or 2005): ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a number.");
                        scanner.next();
                        break;
                    }
                    int searchId = scanner.nextInt();

                    // Map ile arama yapma
                    LibraryItem foundItem = manager.getItemByID(searchId);

                    System.out.println("\n** SEARCH RESULT (Map Lookup) **");
                    if (foundItem != null) {
                        System.out.println("[SUCCESS: Item found via Map's fast key lookup]");
                        System.out.println(foundItem.toString());
                    } else {
                        System.out.println("[FAIL: Item with ID " + searchId + " not found.]");
                    }
                    break;

                case 5:
                    // Kitap ödünç alma
                    book1.rentItem("User A");
                    System.out.println("Current Status: " + book1);
                    break;

                case 6:
                    // Kitap iade etme
                    book1.returnItem();
                    System.out.println("Current Status: " + book1);
                    break;
                case 7:
                    running = false;
                    System.out.println("Exiting Application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}