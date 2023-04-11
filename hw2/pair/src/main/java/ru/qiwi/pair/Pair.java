package ru.qiwi.pair;

import java.util.Objects;

public class Pair <One, Two> {

    One first;
    Two second;

    private Pair(One first, Two second) {
        this.first = first;
        this.second = second;
    }

    public static <One, Two> Pair <One, Two> of(One first, Two second) {
        return new Pair(first, second);
    }

    public One getFirst() {
        return first;
    }

    public Two getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
