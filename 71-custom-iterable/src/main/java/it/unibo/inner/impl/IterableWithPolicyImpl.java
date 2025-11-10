package it.unibo.inner.impl;



import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class IterableWithPolicyImpl<T> implements IterableWithPolicy<T> {
    private final List<T> elements;
    private Predicate<T> filter;

    public IterableWithPolicyImpl(final T[] elements, final Predicate<T> filter) {
        this.elements = List.of(elements);
        this.setIterationPolicy(filter);
    }

    public IterableWithPolicyImpl(final T[] elements){
        this(elements, new Predicate<T>() {
            @Override
            public boolean test(T elem) {
                return true;
            }

        });
    }

    @Override
    public Iterator<T> iterator() {
        return new InnerIterator();
    }
    
    @Override
    public void setIterationPolicy(Predicate<T> filter) {
        this.filter = filter;
    }


/**INNER CLASS */
    private class InnerIterator implements Iterator<T>{
        private int currentIndex;

        public InnerIterator(){
            this.currentIndex = 0;
        }

        @Override
        public T next() {
            if(hasNext()){
                return elements.get(currentIndex++);
            }
            throw new NoSuchElementException();
        }


        @Override
        public boolean hasNext() {
            while(this.currentIndex < elements.size()){
                final T tested = elements.get(currentIndex);
                if(filter.test(tested)){
                    return true;
                }
                this.currentIndex++;
            }
            return false;
        }

    }

}