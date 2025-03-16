package com.mouad.presets;

import com.mouad.dao.IDao;
import com.mouad.metier.IMetier;

public class PresetDynamic {
    public static void main(String[] args) throws Exception {
        // Chargement dynamique de la classe
        Class<?> daoClass = Class.forName("DaoImpl");
        IDao dao = (IDao) daoClass.getDeclaredConstructor().newInstance();

        Class<?> metierClass = Class.forName("MetierImpl");
        IMetier metier = (IMetier) metierClass.getDeclaredConstructor(IDao.class).newInstance(dao);

        System.out.println("Résultat : " + metier.calcul());
    }

}
