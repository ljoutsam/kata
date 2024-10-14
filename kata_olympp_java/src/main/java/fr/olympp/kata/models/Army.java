package fr.olympp.kata.models;

public record Army(String name, FootSoldier footSoldiers) {
    public int getArmyAttack() {
        return footSoldiers.nbUnits() * footSoldiers.attack();
    }

    public int getArmyDefense() {
        return footSoldiers.nbUnits() * footSoldiers.defense();
    }
}
