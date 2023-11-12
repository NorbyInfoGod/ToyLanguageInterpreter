package expressions;

import exceptions.ExpException;
import types.BoolType;
import utils.SymTable;
import values.BoolValue;
import values.Value;

public class LogicExp implements Exp{
    Exp e1,e2;
    int op;//1-and 2-or
    @Override
    public Value eval(SymTable<String,Value> tbl) throws ExpException
    {
        Value v1,v2;
        v1=e1.eval(tbl);
        if(v1.getType().equals(new BoolType()))
        {
            v2=e2.eval(tbl);
            if(v2.getType().equals(new BoolType()))
            {
                BoolValue i1 = (BoolValue) v1;
                BoolValue i2 = (BoolValue) v2;
                boolean n1,n2;
                n1= i1.getVal();
                n2= i2.getVal();
                if(op==1)
                    return new BoolValue(n1&&n2);
                if(op==2)
                    return new BoolValue(n1||n2);
            }
            else
                throw new ExpException("second operand is not a boolean");
        }
        else
            throw new ExpException("first operand is not a boolean");
        return v1;
    }

    @Override
    public Exp deepCopy() {
        return new LogicExp(e1.deepCopy(),e2.deepCopy(),op);
    }

    public LogicExp(Exp e1,Exp e2,int op)
    {
        this.e1 = e1;
        this.e2 = e2;
        this.op = op;
    }
    public String toString()
    {
        String s="";
        if(op==1)
            s=e1.toString()+"&&"+e2.toString();
        if(op==2)
            s=e1.toString()+"||"+e2.toString();
        return s;
    }
}
