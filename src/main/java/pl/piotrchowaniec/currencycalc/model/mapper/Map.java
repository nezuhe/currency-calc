package pl.piotrchowaniec.currencycalc.model.mapper;

public abstract class Map<K, V> {

    public abstract V map(K key);
}
