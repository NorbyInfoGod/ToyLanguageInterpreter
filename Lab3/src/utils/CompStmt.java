package utils;

import state.PrgState;

public class CompStmt implements Stmt {
    Stmt first;
    Stmt snd;

    public CompStmt(Stmt f, Stmt s)
    {
        first=f;
        snd=s;
    }

    public String toString()
    {
        return "("+first.toString() + ';' + snd.toString()+")";
    }
    @Override
    public PrgState execute(PrgState state) {
        ExeStack<Stmt> stk = state.getExeStack();
        stk.push(snd);
        stk.push(first);
        return state;
    }
    public Stmt deepCopy()
    {
        return new CompStmt(first.deepCopy(),snd.deepCopy());
    }

}
