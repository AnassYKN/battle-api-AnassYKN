package TP.service;

import TP.entity.PokemonType;

import java.util.List;

public interface PokemonTypeService {
    PokemonType getPokemonTypeByid(int id);
    List<PokemonType> listPokemonTypes();
}
