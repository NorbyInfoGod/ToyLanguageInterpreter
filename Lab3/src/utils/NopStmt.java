package utils;

import state.PrgState;

public class NopStmt implements Stmt {

    public NopStmt()
    {}

    public String toString(){
        return "Nop";
    }
    @Override
    public PrgState execute(PrgState state) {
        return state;
    }
    public Stmt deepCopy()
    {
        return new NopStmt();
    }
}
