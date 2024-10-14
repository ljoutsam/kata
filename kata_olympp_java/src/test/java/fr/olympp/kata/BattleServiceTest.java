package fr.olympp.kata;

import fr.olympp.kata.models.*;
import fr.olympp.kata.services.BattleService;
import fr.olympp.kata.services.BattleServiceImpl; // Assurez-vous d'importer la bonne implémentation
import fr.olympp.kata.services.ClanService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BattleServiceTest {

    @Mock
    private ClanService clanService; // Service des clans, à simuler

    @InjectMocks
    private BattleServiceImpl battleService; // Utilisation de l'implémentation concrète

    private Clan grec;
    private Clan troyen;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialisation des mocks

        // Création des soldats de pied pour les Grecs et les Troyens
        FootSoldier grecFootSoldier = new FootSoldier(100, 50, 30, 100);
        Army grecArmy = new Army("armée1", grecFootSoldier);

        FootSoldier troyenFootSoldier = new FootSoldier(80, 40, 20, 100);
        Army troyenArmy = new Army("armée2", troyenFootSoldier);

        // Création des clans
        grec = new Clan("grec", List.of(grecArmy));
        troyen = new Clan("troyen", List.of(troyenArmy));
    }


    @Test
    void testBattle_Draw() {
        // Création de soldats de pied avec des statistiques égales pour un match nul
        FootSoldier grecFootSoldier = new FootSoldier(100, 50, 50, 100);
        Army grecArmy = new Army("armée1", grecFootSoldier);

        FootSoldier troyenFootSoldier = new FootSoldier(100, 50, 50, 100);
        Army troyenArmy = new Army("armée2", troyenFootSoldier);

        // Mise à jour des clans avec des armées qui s'égaliseront
        grec = new Clan("grec", List.of(grecArmy));
        troyen = new Clan("troyen", List.of(troyenArmy));

        // Exécution de la bataille
        BattleReport report = battleService.battle(grec, troyen);

        // Assertions pour vérifier le résultat de la bataille
        assertNotNull(report, "Le rapport de bataille ne doit pas être nul");
        assertNull(report.winner(), "Le vainqueur doit être nul en cas de match nul");
        assertEquals("DRAW", report.status(), "Le statut de la bataille doit être MATCH NUL");
    }
}
