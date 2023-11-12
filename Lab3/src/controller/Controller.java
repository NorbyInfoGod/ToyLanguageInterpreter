package controller;

import exceptions.*;
import repository.IRepository;
import state.PrgState;
import utils.ExeStack;
import utils.Stmt;

public class Controller {
    IRepository repo;
    public Controller(IRepository repo)
    {
        this.repo = repo;
    }
    public PrgState oneStep(PrgState state) throws StackException, ValueException, ExpException, SymTableException, StmtException {
        ExeStack<Stmt> stk = state.getExeStack();
        if(stk.isEmpty())
            throw new StackException("prgstate stack is empty");
        Stmt crtStmt = stk.pop();
        return crtStmt.execute(state);
    }
    public void allStep() throws StackException, ValueException, ExpException, SymTableException, StmtException {
        PrgState prg = repo.getCrtPrg();
        System.out.println(prg.toString());
        while(!prg.getExeStack().isEmpty())
        {
            oneStep(prg);
            System.out.println(prg.toString());
        }
        System.out.println(prg.getOut().toString());
    }
    public IRepository getRepo()
    {
        return repo;
    }
}

