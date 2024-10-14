package fr.olympp.kata.models;

import java.util.List;

public record BattleReport(String status, String winner, List<Clan> initialClans, List<BattleTurn> history) {}

