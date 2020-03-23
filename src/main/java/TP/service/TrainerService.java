package TP.service;

import TP.entity.Trainer;

import java.util.List;

public interface TrainerService {

    public List<Trainer> listTrainer();
    Trainer getTrainer(String TrainerName);
    void getPokemonTypeByTrainer(Trainer trainer);
}
