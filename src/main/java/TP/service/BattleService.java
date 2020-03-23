package TP.service;

import TP.bo.Battle;
import org.springframework.data.util.Pair;

import java.util.List;
import java.util.UUID;

public interface BattleService {

    Pair<UUID, Battle> createBattle(String trainer, String opponent);
    List<Battle> getAllBattles();

}
