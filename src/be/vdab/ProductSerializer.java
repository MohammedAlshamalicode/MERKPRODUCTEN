package be.vdab;

import be.vdab.model.Product;
import be.vdab.persistence.Bestelling;

import java.io.*;
import java.util.List;

public class ProductSerializer {

    // طريقة لحفظ القائمة في ملف
    public static void saveProductsToFile(Bestelling bestelling, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            List<Product>productList = bestelling.lijstGesorteerdOpProductnummer();
            oos.writeObject(productList);
            System.out.println("Producten zijn succesvol opgeslagen in: " + filePath);
        } catch (IOException e) {
            System.err.println("Er is een fout opgetreden tijdens het opslaan van de producten: " + e.getMessage());
        }
    }

    // طريقة لاسترجاع القائمة من ملف
    @SuppressWarnings("unchecked")
    public static List<Product> readProductsFromFile(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (List<Product>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Er is een fout opgetreden tijdens het lezen van de producten: " + e.getMessage());
        }
        return null;
    }
}

