package TP.bo;

import java.util.UUID;

public class Battle {

    UUID UUID;
    BattleTrainer trainer;
    BattleTrainer opponent;


    public Battle(java.util.UUID UUID) {
        this.UUID = UUID;
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
