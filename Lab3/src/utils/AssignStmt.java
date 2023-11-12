package utils;

import exceptions.ExpException;
import exceptions.StmtException;
import exceptions.ValueException;
import expressions.Exp;
import state.PrgState;
import types.Type;
import values.Value;

public class AssignStmt implements Stmt {
    String id;
    Exp exp;

    public AssignStmt(String i, Exp e)
    {
        id=i;
        exp=e;
    }

    public String toString(){
        return id+"="+exp.toString();
    }
    @Override
    public PrgState execute(PrgState state) throws  StmtException, ExpException {
        SymTable<String,Value> symTbl = state.getSymTable();
        if (symTbl.isDefined(id))
        {
            Value val = exp.eval(symTbl);
            Type typId = (symTbl.lookup(id)).getType();
            if(val.getType().equals(typId))
                symTbl.update(id,val);
            else
                throw new StmtException("declared type of variable"+id+"and type of the assigned expression do not match");
        }
        else
            throw new StmtException("the used variable"+id+"was not declared before");
        return state;
    }
    public Stmt deepCopy()
    {
        return new AssignStmt(id,exp.deepCopy());
    }
}
