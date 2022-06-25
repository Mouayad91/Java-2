import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

/**
 * Eine Klasse, die die Klasse Lager mit bestimmte eingaben testet.
 * 
 * @author Monzr Hajy Omar und Kabas Algharib
 * 
 * @version 1.0
 */
public class LagerTest {
    /**
     * Lager wird angelegt.
     * 
     * @result lager soll mit 25 groß angelegt sein, ohne fehler zumelden
     * 
     */
    @Test
    public void test_Konstruktor_Lager_lagergroesse_soll_richtig_sein() {
        final int erwartete_lagergroesse = 25;
        Lager lager = new Lager(erwartete_lagergroesse);
        final int echte_lagergroesse = lager.getLagerGroesse2();
        assertEquals(erwartete_lagergroesse, echte_lagergroesse);
    }
    
    @Test
    public void test_Konstruktor_Lager_lagergroesse_soll_richtig_sein2() {
        final int erwartete_lagergroesse = 700;
        Lager lager = new Lager(erwartete_lagergroesse);
        final int echte_lagergroesse = lager.getLagerGroesse2();
        assertEquals(erwartete_lagergroesse, echte_lagergroesse);
    }
    
    /**
     * Lager wird ohne Eingabe automatisch angelegt.
     * 
     * @result lager soll mit 10 groß angelegt sein, ohne fehler zumelden
     * 
     */
    @Test
    public void test_Konstruktor_Lager_lagergroesse_ohne_uebergabe_soll_richtig_sein() {
        final int erwartete_lagergroesse = 10;
        Lager lager = new Lager();
        final int echte_lagergroesse = lager.getLagerGroesse2();
        assertEquals(erwartete_lagergroesse, echte_lagergroesse);
    }
    
    /**
     * Artikel wird ins Lager angelegt.
     * 
     * @result artikel erfolgreich ins lager anlegen, ohne fehler zumelden
     * 
     */
    @Test
    public void test_Artikel_ins_lager_anlegen_soll_richtig_sein() {
        final int erwartete_ArtikelAnzahl = 1;
        final int lagergroesse = 25;
        Lager lager = new Lager(lagergroesse);
        lager.legeAnArtikel(new Artikel(1234, "Tisch", 25, 50.0));      
        final int echte_ArtikelAnzahl = lager.getArtikelAnzahl();
        assertEquals(erwartete_ArtikelAnzahl, echte_ArtikelAnzahl);
    }
    
    @Test
    public void test_Artikel_ins_lager_anlegen_soll_richtig_sein2() {
        final int erwartete_ArtikelAnzahl = 2;
        final int lagergroesse = 15;
        Lager lager = new Lager(lagergroesse);
        lager.legeAnArtikel(new Artikel(1234, "Tisch", 25, 50.0));   
        lager.legeAnArtikel(new Artikel(2345, "PC", 25, 600.0));
        final int echte_ArtikelAnzahl = lager.getArtikelAnzahl();
        assertEquals(erwartete_ArtikelAnzahl, echte_ArtikelAnzahl);
    }
    
    /**
     * Artikel wird vom Lager entfernt.
     * 
     * @result artikel erfolgreich vom lager entfernen, ohne fehler zumelden
     * 
     */
    @Test
    public void test_Artikel_vom_lager_entfernen_soll_richtig_sein() {
        final int erwartete_ArtikelAnzahl = 0;
        final int lagergroesse = 25;
        Lager lager = new Lager(lagergroesse);
        lager.legeAnArtikel(new Artikel(1234, "Tisch", 25, 50.0));      
        lager.entferneArtikel(1234);
        final int echte_ArtikelAnzahl = lager.getArtikelAnzahl();
        assertEquals(erwartete_ArtikelAnzahl, echte_ArtikelAnzahl);
    }
    
    @Test
    public void test_Artikel_vom_lager_entfernen_soll_richtig_sein2() {
        final int erwartete_ArtikelAnzahl = 1;
        final int lagergroesse = 12;
        Lager lager = new Lager(lagergroesse);
        lager.legeAnArtikel(new Artikel(1234, "Tisch", 25, 50.0)); 
        lager.legeAnArtikel(new Artikel(2345, "PC", 25, 600.0));
        lager.entferneArtikel(1234);
        final int echte_ArtikelAnzahl = lager.getArtikelAnzahl();
        assertEquals(erwartete_ArtikelAnzahl, echte_ArtikelAnzahl);
    }
    
    /**
     * Bestand eines Artikels im Lager wird erhoeht.
     * 
     * @result bestand des gewünschten Artikels erhöhen, ohne fehler zumelden
     * 
     */
    @Test
    public void test_bucheZugang_soll_richtig_sein() {
        Lager lager = new Lager();
        final int erwartete_bestand = 50;
        lager.legeAnArtikel(new Artikel(1234, "Tisch", 25, 50.0));
        lager.bucheZugang(1234,25);
        final int echte_bestand = lager.getArtikel(0).getBestand();
        assertEquals(erwartete_bestand, echte_bestand);
    }
    
    @Test
    public void test_bucheZugang_soll_richtig_sein2() {
        Lager lager = new Lager();
        final int erwartete_bestand = 200;
        lager.legeAnArtikel(new Artikel(1234, "Tisch", 25, 50.0));
        lager.bucheZugang(1234,175);
        final int echte_bestand = lager.getArtikel(0).getBestand();
        assertEquals(erwartete_bestand, echte_bestand);
    }
    
    /**
     * Preis eines Artikels im Lager wird erhoeht.
     * 
     * @result preis des gewünschten Artikels erhöhen, ohne fehler zumelden
     * 
     */
    @Test
    public void test_preis_eines_artikels_erhoehen_soll_richtig_sein() {
        Lager lager = new Lager();
        final double erwartete_preis = 150.0;
        lager.legeAnArtikel(new Artikel(1234, "Tisch", 25, 100.0));     
        lager.aenderePreisEinesArtikels(1234,50.0);
        final double echte_preis = lager.getArtikel(0).getPreis();
        assertEquals(erwartete_preis, echte_preis, 0.0);
    }
    
    @Test
    public void test_preis_eines_artikels_erhoehen_soll_richtig_sein2() {
        Lager lager = new Lager();
        final double erwartete_preis = 105.0;
        lager.legeAnArtikel(new Artikel(1234, "Tisch", 25, 100.0));     
        lager.aenderePreisEinesArtikels(1234,5.0);
        final double echte_preis = lager.getArtikel(0).getPreis();
        assertEquals(erwartete_preis, echte_preis, 0.0);
    }
    
    /**
     * Preis eines Artikels im Lager wird verringert.
     * 
     * @result preis des gewünschten Artikels verringern, ohne fehler zumelden
     * 
     */
    @Test
    public void test_preis_eines_artikels_verringern_soll_richtig_sein() {
        Lager lager = new Lager();
        final double erwartete_preis = 50.0;
        lager.legeAnArtikel(new Artikel(1234, "Tisch", 25, 100.0));      
        lager.aenderePreisEinesArtikels(1234,-50.0);
        final double echte_preis = lager.getArtikel(0).getPreis();
        assertEquals(erwartete_preis, echte_preis, 1.0);
    }
    
    @Test
    public void test_preis_eines_artikels_verringern_soll_richtig_sein2() {
        Lager lager = new Lager();
        final double erwartete_preis = 25.0;
        lager.legeAnArtikel(new Artikel(1234, "Tisch", 25, 100.0));      
        lager.aenderePreisEinesArtikels(1234,-75.0);
        final double echte_preis = lager.getArtikel(0).getPreis();
        assertEquals(erwartete_preis, echte_preis, 1.0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_Lager_Konstruktor_mit_ungueltiger_groesse_soll_exception_werfen() {
        Lager lager = new Lager(-10);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_Lager_Konstruktor_mit_ungueltiger_groesse_soll_exception_werfen2() {
        Lager lager = new Lager(-200);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_artikel_anlegen_der_bereits_im_lager_existiert_soll_exception_werfen() {
        Lager lager = new Lager();
        lager.legeAnArtikel(new Artikel(1234, "Tisch", 25, 100.0));
        lager.legeAnArtikel(new Artikel(1234, "PC", 130, 1000.0));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_artikel_anlegen_der_bereits_im_lager_existiert_soll_exception_werfen2() {
        Lager lager = new Lager();
        lager.legeAnArtikel(new Artikel(2000, "Tisch", 54, 99.0));
        lager.legeAnArtikel(new Artikel(2000, "PC", 678, 669.0));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_artikel_anlegen_wenn_lager_voll_ist_soll_exception_werfen() {    
        final int lagergroesse = 1;
        Lager lager = new Lager(lagergroesse);
        lager.legeAnArtikel(new Artikel(1234, "Tisch", 25, 100.0));
        lager.legeAnArtikel(new Artikel(2345, "Radio", 50, 359.99));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_artikel_anlegen_wenn_lager_voll_ist_soll_exception_werfen2() {    
        final int lagergroesse = 2;
        Lager lager = new Lager(lagergroesse);
        lager.legeAnArtikel(new Artikel(1234, "Tisch", 25, 100.0));
        lager.legeAnArtikel(new Artikel(2345, "Radio", 50, 359.99));
        lager.legeAnArtikel(new Artikel(2345, "Laptop", 50, 359.99));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_preisAendern_mit_preis_kleiner_als_null_erwartet_exception() {
        Lager lager = new Lager();
        final Artikel artikel = new Artikel(1234, "Tisch", 75, 50.0);        
        lager.aenderePreisEinesArtikels(1234,-200.0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_preisAendern_mit_preis_kleiner_als_null_erwartet_exception2() {
        Lager lager = new Lager();
        final Artikel artikel = new Artikel(1234, "Smartphone", 60, 399.0);        
        lager.aenderePreisEinesArtikels(1234,-300.0);
    }
    
}
