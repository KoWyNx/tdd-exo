package org.example.exercice4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RechercheVilleTest {
    private RechercheVille rechercheVille;

    @BeforeEach
    public void setUp() {
        rechercheVille = new RechercheVille();
    }

    @Test
    public void testRechercheMoinsDeuxCaracteres() {
        assertThrows(NotImplementedException.class, () -> {
            rechercheVille.rechercher("A");
        }, "Moins de 2 caractères");
    }

    @Test
    public void testRechercheExacte() {
        List<String> resultats = rechercheVille.rechercher("Va");
        assertEquals(Arrays.asList("Valence", "Vancouver"), resultats,
                "La recherche avec 'Va' doit retourner Valence et Vancouver");
    }

    @Test
    public void testRechercheInsensibleCasse() {
        List<String> resultats = rechercheVille.rechercher("va");
        assertEquals(Arrays.asList("Valence", "Vancouver"), resultats,
                "La recherche avec 'va' doit retourner Valence et Vancouver");
    }

    @Test
    public void testRecherchePartielle() {
        List<String> resultats = rechercheVille.rechercher("ape");
        assertEquals(Arrays.asList("Budapest"), resultats,
                "La recherche avec 'ape' doit retourner Budapest");
    }

    @Test
    public void testRechercheAsterisque() {
        List<String> resultats = rechercheVille.rechercher("*");
        assertEquals(Arrays.asList("Paris", "Budapest", "Rotterdam", "Valence", "Vancouver",
                        "Amsterdam", "Vienne"), resultats,
                "La recherche avec '*' doit retourner toutes les villes");
    }
}
