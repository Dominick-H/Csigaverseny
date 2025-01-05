package main;

import controller.Jatek;

public class Csigaverseny {
    public static void main(String[] args) {
        Jatek jatek = new Jatek(); // Játék példány létrehozása
        jatek.fogad();             // Fogadás bekérése
        jatek.verseny();           // Verseny lejátszása
        jatek.eredmeny();          // Eredmények kiírása
    }
}