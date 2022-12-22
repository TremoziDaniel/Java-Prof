package lesson15;

public class Lesson15 {
    public static void main(String[] args) {
        HashTable<String, String> hashT = new HashTable<>();
        hashT.put("Kiev", "Ukraine");
        hashT.put("Krakow", "Poland");
        hashT.put("Paris", "France");
        hashT.put("Kiev", "Ukraine");
        hashT.put("Amsterdam", "Niderland");
        hashT.put("Moscow", "Russia");
        hashT.remove("Krakow");
        hashT.put("Kiev", "Ukraine");
        System.out.println(hashT);
    }
}
