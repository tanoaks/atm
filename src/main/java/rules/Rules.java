package rules;

public interface Rules<P> {
    boolean apply(P p);
}
