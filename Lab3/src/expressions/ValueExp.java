package expressions;

import utils.SymTable;
import values.Value;

public class ValueExp implements Exp{
    Value e;

    @Override
    public Value eval(SymTable<String,Value> tbl)
    {
        return e;
    }
    public ValueExp(Value e)
    {
        this.e = e;
    }
    public Exp deepCopy()
    {
        return new ValueExp(e.deepCopy());
    }
    public String toString()
    {
        return e.toString();
    }
}
