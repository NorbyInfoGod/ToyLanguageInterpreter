package utils;

import exceptions.ExpException;
import exceptions.StmtException;
import exceptions.SymTableException;
import exceptions.ValueException;
import state.PrgState;

public interface Stmt {
    PrgState execute(PrgState state) throws StmtException, ExpException, SymTableException;

    Stmt deepCopy();
}
