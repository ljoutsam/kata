package fr.olympp.kata.controller;

import fr.olympp.kata.models.BattleReport;
import fr.olympp.kata.models.Clan;
import fr.olympp.kata.services.BattleService;
import fr.olympp.kata.services.ClanService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/battles")
public class BattleController {
  private final BattleService battleService;
  private final ClanService clanService;

  public BattleController(BattleService battleService, ClanService clanService) {
    this.battleService = battleService;
    this.clanService = clanService;
  }

  @GetMapping
  public BattleReport battle() {
    List<Clan> clans = this.clanService.getClans();
    if (clans.size() < 2) {
      throw new IllegalArgumentException("Deux clans sont nécessaires pour une bataille.");
    }
    return this.battleService.battle(clans.get(0), clans.get(clans.size() - 1));
  }
}
