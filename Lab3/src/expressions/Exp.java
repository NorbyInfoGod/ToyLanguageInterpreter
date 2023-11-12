package expressions;

import exceptions.ExpException;
import utils.SymTable;
import values.Value;

public interface Exp {
    Value eval(SymTable<String, Value> tbl) throws ExpException;

    Exp deepCopy();
}
