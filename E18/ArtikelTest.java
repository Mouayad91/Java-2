import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

/**
 * Eine Klasse, die die Klasse Artikel mit bestimmte eingaben testet.
 * 
 * @author Monzr Hajy Omar und Kabas Algharib
 * 
 * @version 1.0
 */
public class ArtikelTest {
    /**
     * Artikel wird ohne Fehlermeldungen angelegt.
     * 
     * @result artikel anlegen, ohne fehler zumelden
     * 
     */
    @Test
    public void test_Konstruktor_Artikel_artikelNr_soll_richtig_sein() {
        final int erwartete_artikelNr = 1234;
        Artikel artikel = new Artikel(erwartete_artikelNr, "Tisch", 75, 50.0);
        final int echte_artikelNr = artikel.getArtikelNr();
        assertEquals(erwartete_artikelNr, echte_artikelNr);
    }
    
    @Test
    public void test_Konstruktor_Artikel_artikelNr_soll_richtig_sein2() {
        final int erwartete_artikelNr = 4321;
        Artikel artikel = new Artikel(erwartete_artikelNr, "Tisch", 75, 50.0);
        final int echte_artikelNr = artikel.getArtikelNr();
        assertEquals(erwartete_artikelNr, echte_artikelNr);
    }
    
    /**
     * Bestand eines Artikels wird verringert.
     * 
     * @result bestand des gewünschten Artikels ohne Fehlermeldungen verringern
     * 
     */
    @Test
    public void test_bucheAbgang_soll_richtig_sein() {
        final int erwartete_bestand = 50;
        Artikel artikel = new Artikel(1234, "Tisch", 100, 50.0);
        artikel.bucheAbgang(50);
        final int echte_bestand = artikel.getBestand();
        assertEquals(erwartete_bestand, echte_bestand);
    }
    
        @Test
    public void test_bucheAbgang_soll_richtig_sein2() {
        final int erwartete_bestand = 25;
        Artikel artikel = new Artikel(1234, "Tisch", 100, 50.0);
        artikel.bucheAbgang(75);
        final int echte_bestand = artikel.getBestand();
        assertEquals(erwartete_bestand, echte_bestand);
    }
    
    /**
     * Bestand eines Artikels wird erhöht.
     * 
     * @result bestand des gewünschten Artikels ohne Fehlermeldungen erhöhen
     * 
     */
    @Test
    public void test_bucheZugang_soll_richtig_sein() {
        final int erwartete_bestand = 50;
        Artikel artikel = new Artikel(1234, "Tisch", 25, 50.0);
        artikel.bucheZugang(25);
        final int echte_bestand = artikel.getBestand();
        assertEquals(erwartete_bestand, echte_bestand);
    }
    
    @Test
    public void test_bucheZugang_soll_richtig_sein2() {
        final int erwartete_bestand = 100;
        Artikel artikel = new Artikel(1234, "Tisch", 25, 50.0);
        artikel.bucheZugang(75);
        final int echte_bestand = artikel.getBestand();
        assertEquals(erwartete_bestand, echte_bestand);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_Artikel_Konstruktor_mit_dreiStelligeNummer_soll_exception_werfen() {
        new Artikel(123, "Tisch",50 , 10.0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_Artikel_Konstruktor_mit_dreiStelligeNummer_soll_exception_werfen2() {
        new Artikel(12345, "Tisch",50 , 10.0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_Artikel_Konstruktor_mit_ungueltige_bestand_soll_exception_werfen() {
        new Artikel(1234, "Tisch",-50 , 10.0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_Artikel_Konstruktor_mit_ungueltige_bestand_soll_exception_werfen2() {
        new Artikel(1234, "Tisch",-800 , 10.0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_bucheZugang_mit_menge_kleiner_als_null_erwartet_exception() {
        Artikel artikel = new Artikel(1234, "Tisch", 10, 25);
        artikel.bucheZugang(-5);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_bucheZugang_mit_menge_kleiner_als_null_erwartet_exception2() {
        Artikel artikel = new Artikel(1234, "Tisch", 10, 25);
        artikel.bucheZugang(-20);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_bucheAbgang_mit_bestand_kleiner_als_null_erwartet_exception() {
        Artikel artikel = new Artikel(1234, "Tisch", 10, 25);
        artikel.bucheAbgang(-20);
    }
    
}
