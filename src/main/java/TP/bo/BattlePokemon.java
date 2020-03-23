package TP.bo;

import TP.entity.PokemonType;

public class BattlePokemon {

    private int id;
    private PokemonType pokemonType;
    private int maxHp;
    private int attack;
    private int defense;
    private int speed;
    private int level;
    private int hp;
    private Boolean ko;
    private Boolean alive;

    public BattlePokemon() {}

    public BattlePokemon(int id, PokemonType pokemonType, int maxHp, int attack, int defense, int speed, int level, int hp, Boolean ko, Boolean alive) {
        this.id = id;
        this.pokemonType = pokemonType;
        this.maxHp = maxHp;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.level = level;
        this.hp = hp;
        this.ko = ko;
        this.alive = alive;
    }

    public BattlePokemon(PokemonType pokemonType) {
        this.pokemonType= pokemonType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PokemonType getPokemonType() {
        return pokemonType;
    }

    public void setPokemonType(PokemonType pokemonType) {
        this.pokemonType = pokemonType;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Boolean getKo() {
        return ko;
    }

    public void setKo(Boolean ko) {
        this.ko = ko;
    }

    public Boolean getAlive() {
        return alive;
    }

    public void setAlive(Boolean alive) {
        this.alive = alive;
    }
}
