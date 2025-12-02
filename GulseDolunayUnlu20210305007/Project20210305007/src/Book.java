// extends ıle LibraryItemdan miras alıyoruz
// Ödünçlük durumu için implements ekledik
public class Book extends LibraryItem implements IRentable {

    private String author;
    private boolean isRented; // Yeni özellik ödünç verilip verilmediği

    // Kurucu metot için önce üst sınıfın kurucusunu çağırıyoruz
    public Book(String title, int itemID, String author) {
        super(title, itemID); // Üst sınıfa title ve ID göndermek için
        this.author = author;
    }

    // Polymorphısme zemin hazırlamak için displayInfo metodunu geçersiz kılıyoruz Override ile
    @Override
    public void displayInfo() {
        // Üst sınıftaki bilgileri yazdırıyoruz tekrar sonrasında kendi özelliğini ekliyoruz
        super.displayInfo();
        System.out.println(", Author: " + author);
    }

    // Şimdi de ödünçlük durumu yani IRentable interfaceinden gelen zorunlu kodları buraya ekleyeceğiz
    @Override
    public void rentItem(String renterName) {
        if (!isRented) {
            this.isRented = true;
            System.out.println(this.title + " rented by " + renterName + ".");
        } else {
            System.out.println(this.title + " is already rented.");
        }
    }

    @Override
    public void returnItem() {
        if (isRented) {
            this.isRented = false;
            System.out.println(this.title + " has been returned.");
        } else {
            System.out.println(this.title + " is already in the library.");
        }
    }
    // toString metodumuzu yeni özelliği yansıtacak şekilde güncelleyelim
    @Override
    public String toString() {
        String status = isRented ? " (RENTED)" : " (AVAILABLE)";
        return super.toString() + ", Author: " + author + status;
    }
}
