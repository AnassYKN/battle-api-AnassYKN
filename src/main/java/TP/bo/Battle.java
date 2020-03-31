package TP.bo;

import java.util.UUID;

public class Battle {

    UUID UUID;
    BattleTrainer trainer;
    BattleTrainer opponent;


    public Battle(UUID UUID) {
        this.UUID = UUID;
    }

    public Battle(UUID uuid, BattleTrainer btrainer1, BattleTrainer btrainer2) {
        this.UUID=uuid;
        this.trainer=btrainer1;
        this.trainer=btrainer2;
    }

    public java.util.UUID getUUID() {
        return UUID;
    }

    public void setUUID(java.util.UUID UUID) {
        this.UUID = UUID;
    }

    public BattleTrainer getTrainer() {
        return trainer;
    }

    public void setTrainer(BattleTrainer trainer) {
        this.trainer = trainer;
    }

    public BattleTrainer getOpponent() {
        return opponent;
    }

    public void setOpponent(BattleTrainer opponent) {
        this.opponent = opponent;
    }
}
