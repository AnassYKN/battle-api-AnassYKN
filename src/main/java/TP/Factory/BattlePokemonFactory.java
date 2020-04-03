package TP.Factory;

import TP.Utils.StatsCalculator;
import TP.bo.BattlePokemon;
import TP.entity.PokemonType;
import TP.service.Impl.PokemonTypeServiceImpl;
import TP.service.PokemonTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BattlePokemonFactory {

    @Autowired
    StatsCalculator statsCalculator;

    @Autowired
    PokemonTypeService pokemonTypeService;

    public BattlePokemon createBattlePokemon(PokemonType pokemonType,int level){
        PokemonType pokemonType1 = pokemonTypeService.getPokemonTypeByid(pokemonType.getPokemonTypeId());
        BattlePokemon battlePokemon = new BattlePokemon();
        battlePokemon.setId(pokemonType1.getId());
        battlePokemon.setLevel(level);
        battlePokemon.setPokemonType(pokemonType1);
        battlePokemon.setMaxHp(statsCalculator.calculateHP(battlePokemon.getPokemonType().getStats().getHp(),level));
        battlePokemon.setHp(statsCalculator.calculateHP(battlePokemon.getPokemonType().getStats().getHp(),level));
        battlePokemon.setSpeed(statsCalculator.calculateStat(battlePokemon.getPokemonType().getStats().getSpeed(),level));
        battlePokemon.setDefense(statsCalculator.calculateStat(battlePokemon.getPokemonType().getStats().getDefense(),level));
        battlePokemon.setAttack(statsCalculator.calculateStat(battlePokemon.getPokemonType().getStats().getAttack(),level));
        battlePokemon.setLevel(pokemonType.getLevel());
        return battlePokemon;
    }

}
