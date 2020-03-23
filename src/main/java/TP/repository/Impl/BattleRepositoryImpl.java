package TP.repository.Impl;

import TP.bo.Battle;
import TP.repository.BattleRepository;

import java.util.*;

public class BattleRepositoryImpl implements BattleRepository {

    private Map<UUID,Battle> battles = new HashMap<>();

    @Override
    public UUID createBattle(Battle battle) {
            battles.put(battle.getUUID(),battle);
            return battle.getUUID();
    }

    @Override
    public Battle getBattleByUUID(UUID uuid) {
        if (battles.containsKey(uuid)) {
            return battles.get(uuid);
        }else{
            return null;
        }

    }

    @Override
    public List<Battle> getAllBattles() {
        return (List<Battle>) new HashSet<Battle>(battles.values());
    }
}
