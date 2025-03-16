package com.mouad.presets;

import com.mouad.dao.DaoImpl;
import com.mouad.dao.IDao;
import com.mouad.metier.IMetier;
import com.mouad.metier.MetierImpl;

public class PresetStatic {
    public static void main(String[] args) {
        IDao dao = new DaoImpl(); // Instanciation statique
        IMetier metier = new MetierImpl(dao); // Injection de dépendance
        System.out.println("Résultat : " + metier.calcul());
    }
}
