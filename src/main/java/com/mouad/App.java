package com.mouad;


import com.mouad.metier.IMetier;


@Configuration
@ComponentScan(basePackages = "com.mouad")
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        IMetier metier = context.getBean(IMetier.class);
        System.out.println("Résultat : " + metier.calcul());
    }
}
