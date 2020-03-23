package TP.service.Impl;

import TP.Factory.BattlePokemonFactory;
import TP.bo.Battle;
import TP.repository.BattleRepository;
import TP.service.BattleService;
import TP.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;

import java.util.List;
import java.util.UUID;

public class BattleServiceImpl implements BattleService {

    @Autowired
    private final BattlePokemonFactory battlePokemonFactory;

    @Autowired
    TrainerService trainerService;

    @Autowired
    BattleRepository battleRepository;

    public BattleServiceImpl(BattlePokemonFactory battlePokemonFactory) {
        this.battlePokemonFactory = battlePokemonFactory;
    }

    @Override
    public Pair<UUID, Battle> createBattle(String trainer, String opponent) {
        return null;
    }

    @Override
    public List<Battle> getAllBattles() {
        return this.battleRepository.getAllBattles();
    }
}
