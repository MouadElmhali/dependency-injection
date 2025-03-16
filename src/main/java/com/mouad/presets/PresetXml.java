package com.mouad.presets;

import com.mouad.metier.IMetier;

public class PresetXml {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IMetier metier = (IMetier) context.getBean("metier");
        System.out.println("Résultat : " + metier.calcul());
    }
}
