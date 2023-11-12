package expressions;

import exceptions.ExpException;
import types.IntType;
import utils.SymTable;
import values.IntValue;
import values.Value;

public class ArithExp implements Exp{
    Exp e1;
    Exp e2;
    int op;//1-plus, 2-minus, 3-star, 4-divide
    @Override
    public Value eval(SymTable<String, Value> tbl) throws ExpException {
        Value v1,v2;
        v1=e1.eval(tbl);
        if(!v1.getType().equals(new IntType()))
        {
            throw new ExpException("first operand is not an integer");
        }
        else{
            v2=e2.eval(tbl);
            if(!v2.getType().equals(new IntType())) {
                throw new ExpException("second operand is not an integer");
            }
            else {
                IntValue i1 = (IntValue)v1;
                IntValue i2 = (IntValue)v2;
                int n1,n2;
                n1=i1.getVal();
                n2= i2.getVal();
                if(op==1)
                    return new IntValue(n1+n2);
                if(op==2)
                    return new IntValue(n1-n2);
                if(op==3)
                    return new IntValue(n1*n2);
                if(op==4) {
                    if(n2!=0)
                        return new IntValue(n1/n2);
                    else
                        throw new ExpException("division by zero");
                }
            }
        }
        return v1;
    }
    public ArithExp(Exp e1, Exp e2, int op)
    {
        this.e1=e1;
        this.e2=e2;
        this.op=op;
    }
    public String toString()
    {
        String s="";
        if(op==1)
            s=e1.toString()+"+"+e2.toString();
        if(op==2)
            s=e1.toString()+"-"+e2.toString();
        if(op==3)
            s=e1.toString()+"*"+e2.toString();
        if(op==4)
            s=e1.toString()+"/"+e2.toString();
        return s;
    }
    public Exp deepCopy()
    {
        return new ArithExp(e1.deepCopy(),e2.deepCopy(),op);
    }
}
