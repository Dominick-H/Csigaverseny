package mode1;

import java.util.Random;

// A Csiga osztály: kezeli a csiga tulajdonságait és mozgását.
public class Csiga {
    private static final Random rnd = new Random(); // Véletlenszám-generátor
    private final String szín; // Csiga színe
    private int pozicio = 0; // Csiga aktuális pozíciója
    private boolean gyorsito = false; // Gyorsító állapot

    // Konstruktor: Inicializálja a csigát a színnel
    public Csiga(String szin) {
        this.szín = szin;
    }

    // Szín lekérdezése
    public String getSzin() {
        return szín;
    }

    // Pozíció lekérdezése
    public int getPozicio() {
        return pozicio;
    }

    // Csiga mozgása (0-3 véletlenszerű egység, gyorsítóval duplázva)
    public void mozog() {
        int leptek = rnd.nextInt(4); // 0..3 lépés generálása
        if (gyorsito) {
            leptek *= 2; // Ha van gyorsító, duplázza a lépéseket
            gyorsito = false; // Gyorsító egyszer használható
        }
        pozicio += leptek;
    }

    // Gyorsító aktiválása
    public void kapGyorsitot() {
        this.gyorsito = true;
    }
}