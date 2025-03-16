package com.mouad.metier;

import com.mouad.dao.IDao;

@Component
public class MetierImpl implements IMetier{

    private IDao dao;

    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {
        double data = dao.getData();
        return data * 2;
    }
}
