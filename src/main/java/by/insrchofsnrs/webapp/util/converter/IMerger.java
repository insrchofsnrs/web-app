package by.insrchofsnrs.webapp.util.converter;

public interface IMerger<T , K> {
   T merge (T t, K k);
}
