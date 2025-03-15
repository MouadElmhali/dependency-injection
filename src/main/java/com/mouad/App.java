package com.mouad;

import com.mouad.dao.DaoImpl;
import com.mouad.dao.IDao;
import com.mouad.metier.IMetier;
import com.mouad.metier.MetierImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        IDao dao = new DaoImpl();
        IMetier metier = new MetierImpl(dao);
        System.out.println("Résultat : " + metier.calcul());
    }
}
