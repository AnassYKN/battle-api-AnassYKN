package TP.repository;


import TP.bo.Battle;

import java.util.HashSet;
import java.util.UUID;


public interface BattleRepository {
    Battle createBattle(Battle battle);
    Battle getBattleByUUID(UUID uuid);
    HashSet<Battle> getAllBattles();
}
