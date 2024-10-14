package fr.olympp.kata.repository;

import fr.olympp.kata.models.BattleReport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryBattleReportRepository implements BattleReportRepository {
    private final List<BattleReport> reports = new ArrayList<>();

    @Override
    public void create(BattleReport battleReport) {
        reports.add(battleReport);
    }
}

