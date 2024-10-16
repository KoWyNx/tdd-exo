package TDD.exercice4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RechercheVille {
    private List<String> villes;

    public RechercheVille() {
        this.villes = new ArrayList<>(Arrays.asList(
                "Paris", "Budapest", "Rotterdam",
                "Valence", "Vancouver", "Amsterdam", "Vienne"
        ));
    }

    public List<String> rechercher(String mot)  {
        if (mot.length() < 2 && !mot.equals("*")) {
            throw new NotImplementedException("Le texte de recherche doit contenir au moins 2 caractères.");
        }
        if (mot.equals("*")) {
            return new ArrayList<>(villes);
        }

        return villes.stream()
                .filter(ville -> ville.toLowerCase().contains(mot.toLowerCase()))
                .collect(Collectors.toList());

    }
}
