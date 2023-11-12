package utils;

import exceptions.StackException;
import exceptions.StmtException;
import exceptions.SymTableException;
import state.PrgState;
import types.BoolType;
import types.IntType;
import types.Type;
import values.BoolValue;
import values.IntValue;
import values.Value;

public class VarDeclStmt implements Stmt {
    String name;
    Type typ;

    public VarDeclStmt(String n, Type t) {
        name=n;
        typ=t;
    }

    public String toString(){
        return typ.toString() + " " + name;
    }
    @Override
    public PrgState execute(PrgState state) throws StmtException, SymTableException {
        SymTable<String, Value> st = state.getSymTable();
        if(st.lookup(name) == null)
        {
            if(typ.equals(new BoolType()))
                st.put(name, new BoolValue());
            else if(typ.equals(new IntType()))
                st.put(name, new IntValue());
        }
        else
            throw new StmtException("Variable already declared");
        return state;
    }


    public Stmt deepCopy()
    {
        return new VarDeclStmt(name,typ);
    }
}
