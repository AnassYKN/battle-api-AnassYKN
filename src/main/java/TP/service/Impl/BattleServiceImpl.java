package TP.service.Impl;

import TP.Factory.BattlePokemonFactory;
import TP.bo.Battle;
import TP.bo.BattlePokemon;
import TP.bo.BattleTrainer;
import TP.entity.PokemonType;
import TP.entity.Trainer;
import TP.repository.BattleRepository;
import TP.service.BattleService;
import TP.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
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


        trainer1.getTeam().forEach(pokemonType ->
                                   lptrainer1.add(battlePokemonFactory.createBattlePokemon(pokemonType,pokemonType.getLevel())));
        trainer2.getTeam().forEach(pokemonType ->
                                   lptrainer2.add(battlePokemonFactory.createBattlePokemon(pokemonType,pokemonType.getLevel())));




        PokemonType bptrainer1 = lptrainer1.stream().filter(pokemon -> !pokemon.getKo() && pokemon.getAlive()).findFirst().get().getPokemonType();
        PokemonType bptrainer2 = lptrainer2.stream().filter(pokemon -> !pokemon.getKo() && pokemon.getAlive()).findFirst().get().getPokemonType();

        btrainer1.setTeam(lptrainer1);
        btrainer2.setTeam(lptrainer2);

        Battle battle = new Battle(uuid,btrainer1,btrainer2);

        if (bptrainer1.getStats().getSpeed() >= bptrainer2.getStats().getSpeed()){
            battle.getTrainer().setNextTurn(true);
            battle.getOpponent().setNextTurn(false);
        }  else {
            battle.getTrainer().setNextTurn(false);
            battle.getOpponent().setNextTurn(true);
        }

        battleRepository.createBattle(battle);

        return Pair.of(uuid,battle);

    }

    @Override
    public HashSet<Battle> getAllBattles() {
        return this.battleRepository.getAllBattles();
    }

    @Override
    public Battle getBattleByUUID(UUID uuid) {
        return this.battleRepository.getBattleByUUID(uuid);
    }

    @Override
    public Battle attackBattle(UUID uuid, String trainerName) {
        Battle battle = this.battleRepository.getBattleByUUID(uuid);

        BattleTrainer trainer = battle.getTrainer().getName().equals(trainerName) ? battle.getTrainer() : battle.getOpponent();;
        BattleTrainer opponent = battle.getTrainer().getName().equals(trainerName) ? battle.getOpponent() : battle.getTrainer();

        BattlePokemon pokemontrainer  = getFirstPokemonAlive(trainer.getTeam());
        BattlePokemon pokemonOpponent = getFirstPokemonAlive(opponent.getTeam());

        if(trainer.getNextTurn()){
            int scoreAttack = ((2*pokemontrainer.getLevel()/5) + (2*pokemontrainer.getAttack()/pokemontrainer.getDefense())+2);

            if(pokemonOpponent.getHp() - scoreAttack < 0){
                pokemonOpponent.setHp(0);
                pokemonOpponent.setKo(true);
                pokemonOpponent.setAlive(false);
            }else{
                pokemonOpponent.setHp(pokemonOpponent.getHp()-scoreAttack);
            }

            trainer.setNextTurn(false);
            opponent.setNextTurn(true);

        }

        return battle;
    }

    private BattlePokemon getFirstPokemonAlive(List<BattlePokemon> pokemons){
        return pokemons.stream().filter(battlePokemon -> battlePokemon.getAlive()).findFirst().get();

    }
}
