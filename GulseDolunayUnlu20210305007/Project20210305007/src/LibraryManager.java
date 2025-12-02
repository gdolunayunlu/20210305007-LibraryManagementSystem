import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;
// Jenerik sınıf tanımı T sadece LibraryItem veya alt sınıfları olabiliyor
public class LibraryManager<T extends LibraryItem> {
    //Listeleme ve filtreleme icin List ekliyoruz
    private List<T> itemList;
    //ID ile hizli arama icin map ekliyoruz
    private Map<Integer, T> itemMap;

    public LibraryManager() {
        this.itemList = new ArrayList<>();
        this.itemMap = new HashMap<>();
    }

    public void addItem(T item) {
        itemList.add(item);
        itemMap.put(item.itemID, item);
        System.out.println(item.title + " successfully added to the system.");
    }

    // Listeyi dolaşıp tüm öğelerin bilgilerini yazdıran metot
    public void displayAllItems() {
        System.out.println("\n--- ALL LIBRARY ITEMS IN THE MANAGER ---");
        // Lambda Fonksiyonu ile yazdırma
        itemList.forEach(item -> System.out.println(item.toString()));
    }

    // Lambda Fonksiyonu ile öğeleri başlığa göre filtreleyebiliyoruz
    public List<T> filterItemsByTitle(String keyword) {
        // Lambda Fonksiyonu: Başlığı verilen kelimeyi içeren öğeleri filtreler
        List<T> filteredList = itemList.stream()
                .filter(item -> item.title.contains(keyword)) // Lambda İfadesi (item -> ...)
                .collect(Collectors.toList());

        return filteredList;
    }

    public T getItemByID(int id) {
        System.out.println("[INFO: Lookup for ID: " + id + "]");
        // ID ile doğrudan ve hızlı erişim
        return itemMap.get(id);
    }

    // jenerik metodumuz
    public int getTotalCount() {
        return itemList.size();
    }
}

