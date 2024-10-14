package fr.olympp.kata.models;

import java.util.ArrayList;
import java.util.List;

public record Clan(String name, List<Army> armies) {

    public Clan {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Le nom du clan ne peut pas être vide.");
        }
        if (armies == null) {
            armies = new ArrayList<>(); // Initialise une liste vide si non fournie
        }
    }

    public boolean hasRemainingArmies() {
        return armies.stream().anyMatch(army -> army.footSoldiers().nbUnits() > 0);
    }
}
