package types;

public interface Type {
    Type deepCopy();
    boolean equals(Object another);
}
