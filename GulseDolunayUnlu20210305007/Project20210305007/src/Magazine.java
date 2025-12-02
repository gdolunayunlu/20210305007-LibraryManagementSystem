// extends kullanarak LibraryItemdan miras aldık
public class Magazine extends LibraryItem {

    private int issueNumber; // Dergiye özel özelliğimiz

    public Magazine(String title, int itemID, int issueNumber) {
        super(title, itemID); // Üst sınıfa title ve ID gönderiyoruz
        this.issueNumber = issueNumber;
    }

    // displayInfo metodunu geçersiz kılıyoruz
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Issue Number: " + issueNumber);
    }

    @Override
    public String toString() {
        return super.toString() + ", Issue: " + issueNumber;
    }
}
