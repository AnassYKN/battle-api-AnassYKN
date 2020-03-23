package TP.Factory;

import TP.Utils.StatsCalculator;
import TP.bo.BattlePokemon;
import TP.entity.PokemonType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BattlePokemonFactory {

    @Autowired
    StatsCalculator statsCalculator;

    public BattlePokemon createBattlePokemon(PokemonType pokemonType,int level){
        BattlePokemon battlePokemon = new BattlePokemon(pokemonType);
        battlePokemon.setMaxHp(statsCalculator.calculateHP(pokemonType.getStats().getHp(),level));
        battlePokemon.setHp(statsCalculator.calculateHP(pokemonType.getStats().getHp(),level));
        battlePokemon.setSpeed(statsCalculator.calculateStat(pokemonType.getStats().getSpeed(),level));
        battlePokemon.setDefense(statsCalculator.calculateStat(pokemonType.getStats().getDefense(),level));
        battlePokemon.setAttack(statsCalculator.calculateStat(pokemonType.getStats().getAttack(),level));
        battlePokemon.setLevel(pokemonType.getLevel());
        return battlePokemon;
    }

}
