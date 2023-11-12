import exceptions.*;
import view.IView;
import view.TextView;

public class Main {
    public static void main(String[] args) throws ExpException, StackException, ValueException, TypeException, StmtException, OutputException, SymTableException {
        IView view = new TextView();
        view.run();
    }
}
