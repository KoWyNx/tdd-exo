package org.example.exercice4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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


}
