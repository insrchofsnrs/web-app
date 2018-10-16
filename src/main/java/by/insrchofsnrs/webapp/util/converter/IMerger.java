package by.insrchofsnrs.webapp.util.converter;

@FunctionalInterface
public interface IMerger<T , K> {
   T merge (T t, K k);
}
