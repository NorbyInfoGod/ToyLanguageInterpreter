package view;

import exceptions.*;

public interface IView {
    void run() throws ExpException, StackException, ValueException, TypeException, StmtException, OutputException, SymTableException;
}
