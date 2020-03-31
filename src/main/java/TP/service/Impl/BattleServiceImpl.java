package TP.service.Impl;

import TP.Factory.BattlePokemonFactory;
import TP.bo.Battle;
import TP.bo.BattlePokemon;
import TP.bo.BattleTrainer;
import TP.entity.Trainer;
import TP.repository.BattleRepository;
import TP.service.BattleService;
import TP.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
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

        var uuid = UUID.randomUUID();
        Trainer trainer1 = trainerService.getTrainer(trainer);
        Trainer trainer2 = trainerService.getTrainer(opponent);

        BattleTrainer btrainer1 = new BattleTrainer(trainer);
        BattleTrainer btrainer2 = new BattleTrainer(opponent);

        List<BattlePokemon> lptrainer1 = new ArrayList<>();
        List<BattlePokemon> lptrainer2 = new ArrayList<>();

        trainer1.getTeam().forEach(pokemonType -> lptrainer1.add(this.battlePokemonFactory.createBattlePokemon(pokemonType,pokemonType.getLevel())));
        trainer2.getTeam().forEach(pokemonType -> lptrainer2.add(this.battlePokemonFactory.createBattlePokemon(pokemonType,pokemonType.getLevel())));

        btrainer1.setTeam(lptrainer1);
        btrainer2.setTeam(lptrainer2);

        return Pair.of(uuid,new Battle(uuid,btrainer1,btrainer2));

    }

    @Override
    public List<Battle> getAllBattles() {
        return this.battleRepository.getAllBattles();
    }

    @Override
    public Battle getBattleByUUID(UUID uuid) {
        return this.battleRepository.getBattleByUUID(uuid);
    }
}
