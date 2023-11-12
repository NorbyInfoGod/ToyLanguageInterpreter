package types;

public class BoolType implements Type{
    @Override
    public boolean equals(Object another)
    {
        if (another instanceof BoolType)
            return true;
        return false;
    }
    public String toString()
    {
        return "bool";
    }

    @Override
    public Type deepCopy() {
        return this;
    }
}
