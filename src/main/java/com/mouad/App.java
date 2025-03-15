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
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IMetier metier = (IMetier) context.getBean("metier");
        System.out.println("Résultat : " + metier.calcul());
    }
}
