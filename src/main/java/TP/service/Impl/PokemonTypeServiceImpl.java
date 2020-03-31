package TP.service.Impl;

import TP.entity.PokemonType;
import TP.service.PokemonTypeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService {

    private RestTemplate restTemplate;
    private String pokemonServiceUrl;

    @Override
    public PokemonType getPokemonTypeByid(int id) {
        PokemonType pokemonType = this.restTemplate.getForObject(pokemonServiceUrl+"/pokemon-types/"+id, PokemonType.class);
        return pokemonType;
    }

    @Override
    public List<PokemonType> listPokemonTypes() {
        PokemonType[] listPokemon = this.restTemplate.getForObject(pokemonServiceUrl+"/pokemon-types/", PokemonType[].class);
        return List.of(listPokemon);
    }


    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate=restTemplate;
    }

    @Value("https://pokemon-type-api-anassykn.herokuapp.com")
    public void setPokemonTypeServiceUrl(String pokemonServiceUrl) {
        this.pokemonServiceUrl = pokemonServiceUrl;
    }
}
