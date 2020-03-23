package TP.bo;

import java.util.List;

public class BattleTrainer {

    private String name;
    private List<BattlePokemon> team;
    private Boolean nextTurn;

    public BattleTrainer() {}

    public BattleTrainer(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BattlePokemon> getTeam() {
        return team;
    }

    public void setTeam(List<BattlePokemon> team) {
        this.team = team;
    }

    public Boolean getNextTurn() {
        return nextTurn;
    }

    public void setNextTurn(Boolean nextTurn) {
        this.nextTurn = nextTurn;
    }
}
