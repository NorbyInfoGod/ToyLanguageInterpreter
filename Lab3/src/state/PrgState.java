package state;

import utils.SymTable;
import utils.Output;
import utils.ExeStack;
import utils.Stmt;
import values.Value;

public class PrgState {
    ExeStack<Stmt> exeStack;
    SymTable<String,Value> symTable;
    Output<Value> out;
    Stmt originalProgram;

    public PrgState(ExeStack<Stmt> stk, SymTable<String,Value> symtbl, Output<Value> ot, Stmt prg)
    {
        exeStack = stk;
        symTable = symtbl;
        out = ot;
        originalProgram = prg.deepCopy();
        stk.push(prg);
    }
    @Override
    public String toString()
    {
        return "ExeStack:\n"+exeStack.toString()+"\nSymTable:\n"+symTable.toString()+"\nOut:\n"+out.toString()+"\n";
    }
    public ExeStack<Stmt> getExeStack()
    {
        return exeStack;
    }
    public SymTable<String,Value> getSymTable()
    {
        return symTable;
    }
    public Output<Value> getOut()
    {
        return out;
    }
    public Stmt getOriginalProgram()
    {
        return originalProgram;
    }

    public void setExeStack(ExeStack<Stmt> stk)
    {
        exeStack = stk;
    }

    public void setSymTable(SymTable<String,Value> symtbl)
    {
        symTable = symtbl;
    }

    public void setOut(Output<Value> ot)
    {
        out = ot;
    }

    public void setOriginalProgram(Stmt prg)
    {
        originalProgram = prg;
    }
}
