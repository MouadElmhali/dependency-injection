package com.mouad.presets;

import com.mouad.metier.IMetier;


@Configuration
@ComponentScan(basePackages = "com.example")
public class AppConfig {
}

public class PresetAnnotation {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        IMetier metier = context.getBean(IMetier.class);
        System.out.println("Résultat : " + metier.calcul());
    }
}
