package values;


import types.BoolType;
import types.Type;

public class BoolValue implements Value{
    boolean val=false;
    public BoolValue(){}
    public BoolValue(boolean v)
    {
        val=v;
    }

    public boolean getVal()
    {
        return val;
    }
    public String toString()
    {
        return Boolean.toString(val);
    }
    public Type getType()
    {
        return new BoolType();
    }
    public Value deepCopy()
    {
        return new BoolValue(val);
    }
}
