package fr.olympp.kata.repository;

import fr.olympp.kata.models.Clan;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class InMemoryClanRepository implements ClanRepository {

    private final Map<String, Clan> clans = new HashMap<>();

    @Override
    public void addClan(Clan clan) {
        clans.put(clan.name(), clan);
    }

    @Override
    public Clan updateClan(Clan clan) {
        if (!clans.containsKey(clan.name())) {
            throw new IllegalArgumentException("Le clan n'existe pas.");
        }
        clans.put(clan.name(), clan);
        return clan;
    }

    @Override
    public Clan getClan(String name) {
        return clans.get(name);
    }

    @Override
    public List<Clan> getClans() {
        return new ArrayList<>(clans.values());
    }


}
