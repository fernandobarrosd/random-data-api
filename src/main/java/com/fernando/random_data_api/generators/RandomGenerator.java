package com.fernando.random_data_api.generators;

/**
 * @param <P> As informações que devem ser passadas para poder randonizar os dados  
 * @param <T> A informação que foi randonizada
 */
public interface RandomGenerator<P, T> {
    T generateRandom(P params);
}