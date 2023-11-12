package types;

public class IntType implements Type{
    @Override
    public boolean equals(Object another)
    {
        if(another instanceof IntType)
            return true;
        return false;
    }
    public String toString()
    {
        return "int";
    }

    @Override
    public Type deepCopy() {
        return this;
    }
}
