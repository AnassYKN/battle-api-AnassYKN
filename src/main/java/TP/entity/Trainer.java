package TP.entity;

import java.util.List;

public class Trainer {

    private String name;
    private List<PokemonType> team;

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public List<PokemonType> getTeam() { return team; }

    public void setTeam(List<PokemonType> team) { this.team = team; }
}
