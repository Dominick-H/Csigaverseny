package controller;

import mode1.Csiga;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// A Jatek osztály: kezeli a játék logikáját és a felhasználói interakciókat
public class Jatek {
    private static final int KOROK_SZAMA = 5; // A játék 5 körből áll
    private final List<Csiga> csigak = new ArrayList<>(); // A játékban résztvevő csigák listája
    private String fogadas; // A játékos fogadása

    // Konstruktor: Inicializálja a csigákat
    public Jatek() {
        csigak.add(new Csiga("piros"));
        csigak.add(new Csiga("zöld"));
        csigak.add(new Csiga("kék"));
    }

    // Fogadás bekérése a játékostól
    public void fogad() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Tippeld meg a nyertes csiga színét (piros, zöld, kék): ");
        fogadas = scanner.nextLine().trim();
    }

    // A játék 5 körének lejátszása
    public void verseny() {
        Random rnd = new Random();
        for (int i = 0; i < KOROK_SZAMA; i++) {
            System.out.println("Kör " + (i + 1) + ":");
            for (Csiga csiga : csigak) {
                csiga.mozog(); // Csiga mozgatása
                System.out.println(csiga.getSzin() + " csiga pozíciója: " + csiga.getPozicio());
            }

            // 20% eséllyel egy csiga gyorsítót kap
            if (rnd.nextDouble() < 0.2) {
                Csiga gyorsitottCsiga = csigak.get(rnd.nextInt(csigak.size()));
                gyorsitottCsiga.kapGyorsitot();
                System.out.println(gyorsitottCsiga.getSzin() + " csiga gyorsítót kapott!");
            }
            System.out.println();
        }
    }

    // A játék nyertesének meghatározása és eredmény kiírása
    public void eredmeny() {
        Csiga nyertes = csigak.get(0);
        for (Csiga csiga : csigak) {
            if (csiga.getPozicio() > nyertes.getPozicio()) {
                nyertes = csiga;
            }
        }

        System.out.println("A nyertes csiga: " + nyertes.getSzin() + " (Távolság: " + nyertes.getPozicio() + ")");
        if (nyertes.getSzin().equalsIgnoreCase(fogadas)) {
            System.out.println("Gratulálok, eltaláltad a nyertest!");
        } else {
            System.out.println("Sajnos nem nyertél.");
        }
    }
}