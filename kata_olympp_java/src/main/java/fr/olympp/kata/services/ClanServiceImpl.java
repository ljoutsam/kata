package fr.olympp.kata.services;

import fr.olympp.kata.models.Army;
import fr.olympp.kata.models.Clan;
import fr.olympp.kata.repository.ClanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClanServiceImpl implements ClanService{

    private final ClanRepository clanRepository;

    public ClanServiceImpl(ClanRepository clanRepository) {
        this.clanRepository = clanRepository;
    }

    @Override
    public void addClan(Clan clan) {
        clanRepository.addClan(clan);
    }
    @Override
    public Clan getClan(String clanName) {
        return clanRepository.getClan(clanName);
    }

    @Override
    public List<Clan> getClans() {
        return clanRepository.getClans();
    }

    @Override
    public void addArmy(String clanName, Army army) {
        Clan clan = clanRepository.getClan(clanName);
        if (clan == null) {
            System.out.println("Clan not found: " + clanName);
            throw new ClanNotFoundException("Clan not found with name: " + clanName);
        }
        clan.armies().add(army);
        clanRepository.updateClan(clan);
    }

    @Override
    public void removeArmy(String clanName, String armyName) {
        Clan clan = clanRepository.getClan(clanName);
        clan.armies().removeIf(army -> army.name().equals(armyName));
        clanRepository.updateClan(clan);
    }
}
