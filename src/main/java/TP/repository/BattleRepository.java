package TP.repository;


import TP.bo.Battle;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


public interface BattleRepository {
    Battle createBattle(Battle battle);
    Battle getBattleByUUID(UUID uuid);
    List<Battle> getAllBattles();
}
