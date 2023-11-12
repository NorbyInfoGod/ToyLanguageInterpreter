package utils;

import exceptions.ExpException;
import exceptions.StmtException;
import expressions.Exp;
import state.PrgState;
import types.BoolType;
import values.BoolValue;
import values.Value;

public class IfStmt implements Stmt {
    Exp exp;
    Stmt thenS;
    Stmt elseS;

    public IfStmt(Exp e, Stmt t, Stmt el)
    {
        exp=e;
        thenS = t;
        elseS = el;
    }
    public String toString()
    {
        return "(IF("+exp.toString()+")THEN("+thenS.toString()+")ELSE("+elseS.toString()+"))";
    }

    @Override
    public PrgState execute(PrgState state) throws ExpException, StmtException {
        SymTable<String,Value> symTbl = state.getSymTable();
        ExeStack<Stmt> stk = state.getExeStack();
        Value cond = exp.eval(symTbl);
        if(!cond.getType().equals(new BoolType()))
            throw new StmtException("conditional expr not a boolean");
        else
        {
            BoolValue c1 = (BoolValue) cond;
            if(c1.getVal())
                stk.push(thenS);
            else
                stk.push(elseS);

        }
        return state;
    }
    public Stmt deepCopy()
    {
        return new IfStmt(exp.deepCopy(),thenS.deepCopy(),elseS.deepCopy());
    }

}
