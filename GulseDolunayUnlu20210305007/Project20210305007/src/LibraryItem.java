// Kütüphanedeki her şeyin temel sınıfı
public class LibraryItem {
    // Miras alan alt sınıflar erişebilsin diye protected yaptık
    protected String title;
    protected int itemID;

    // Kurucu Metodumuz
    public LibraryItem(String title, int itemID) {
        this.title = title;
        this.itemID = itemID;
    }

    // Alt sınıflarımızın kullanabilmesi için ortak bir metot tanımlıyoruz
    public void displayInfo() {
        System.out.println("Item ID:  " + itemID + ", Title: " + title);
    }
    @Override
    public String toString() {
        return "Type: Library Item, ID: " + itemID + ", Title: " + title;
    }

}
