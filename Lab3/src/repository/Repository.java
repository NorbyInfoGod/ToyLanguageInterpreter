package repository;

import state.PrgState;

public class Repository implements IRepository{
    PrgState crtPrg;
    public Repository(PrgState crtPrg)
    {
        this.crtPrg = crtPrg;
    }
    @Override
    public PrgState getCrtPrg() {
        return crtPrg;
    }
}
