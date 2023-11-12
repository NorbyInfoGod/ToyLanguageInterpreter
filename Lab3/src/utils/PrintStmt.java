package utils;

import exceptions.ExpException;
import exceptions.ValueException;
import expressions.Exp;
import state.PrgState;
import values.Value;

public class PrintStmt implements Stmt {
    Exp exp;
    public PrintStmt(Exp e)
    {
        exp=e;
    }

    public String toString(){
        return "print("+exp.toString()+")";
    }
    @Override
    public PrgState execute(PrgState state) throws ExpException {
        Output<Value> out = state.getOut();
        SymTable<String, Value> symTbl = state.getSymTable();
        out.add(exp.eval(symTbl));
        return state;
    }
    public Stmt deepCopy()
    {
        return new PrintStmt(exp.deepCopy());
    }
}
