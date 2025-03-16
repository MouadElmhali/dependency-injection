package com.mouad.framework;

import com.mouad.metier.IMetier;

public class Main {
    public static void main(String[] args) throws Exception {
        MiniFramework framework = new MiniFramework();
        framework.loadContext("config.xml");

        IMetier metier = (IMetier) framework.getBean("metier");
        System.out.println("Résultat : " + metier.calcul());
    }
}