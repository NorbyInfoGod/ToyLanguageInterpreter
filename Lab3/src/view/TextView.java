package view;

import controller.Controller;
import exceptions.*;
import expressions.ArithExp;
import expressions.ValueExp;
import repository.IRepository;
import repository.Repository;
import state.PrgState;
import types.IntType;
import utils.*;
import values.BoolValue;
import values.IntValue;
import values.Value;

public class TextView implements IView{
    Controller controller;

    public TextView()
    {
        IRepository repo = setUpRepo();
        controller = new Controller(repo);
    }

    private static IRepository setUpRepo() {
        PrgState prg = new PrgState(new ExeStackImplementation<Stmt>(), new SymTableDict<String, Value>(), new OutputList<Value>(), new CompStmt(new VarDeclStmt("v", new IntType()), new CompStmt(new AssignStmt("v", new ValueExp(new IntValue(2))), new CompStmt(new IfStmt(new ValueExp(new BoolValue(true)), new PrintStmt(new ValueExp(new IntValue(1))), new PrintStmt(new ValueExp(new IntValue(2)))), new PrintStmt(new ArithExp(new ValueExp(new IntValue(1111)), new ValueExp(new IntValue(2)), 3))))));
        return new Repository(prg);
    }
    @Override
    public void run(){
        try {
            controller.allStep();
        }
        catch (ExpException | StackException | ValueException | StmtException |
               SymTableException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
