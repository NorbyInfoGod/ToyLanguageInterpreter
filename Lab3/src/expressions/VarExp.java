package expressions;

import exceptions.ExpException;
import utils.SymTable;
import values.Value;

public class VarExp implements Exp{
    String id;

    public VarExp(String id) {
        this.id = id;
    }

    @Override
    public Value eval(SymTable<String,Value> tbl) throws ExpException
    {
        if (tbl.isDefined(id))
            return tbl.lookup(id);
        throw new ExpException("Variable is not defined");
    }
    public Exp deepCopy()
    {
        return new VarExp(id);
    }
    public String toString()
    {
        return id;
    }
}
