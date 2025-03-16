Projet : Injection des Dépendances
Ce projet est une application Java qui illustre le concept d'injection des dépendances. Il est divisé en deux parties principales :

Partie 1 : Création d'interfaces et d'implémentations avec injection des dépendances.

Partie 2 : Développement d'un mini Framework d'injection des dépendances.

Structure du Projet
Copy
dependency-injection-project/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── example/
│   │   │   │   │   ├── dao/                     # Contient l'interface IDao et son implémentation
│   │   │   │   │   ├── metier/                  # Contient l'interface IMetier et son implémentation
│   │   │   │   │   ├── framework/               # Contient le mini Framework d'injection des dépendances
│   │   │   │   │   ├── presets/      
│   │   ├── resources/
│   │   │   ├── applicationContext.xml           # Configuration Spring (XML)
│   │   │   └── config.xml                       # Configuration du mini Framework (XML)
└── README.md                                    # Ce fichier
Partie 1 : Interfaces et Implémentations
1. Interface IDao
   Rôle : Définit une méthode getData() pour récupérer des données.

Fichier : src/main/java/com/example/dao/IDao.java

java
Copy
public interface IDao {
double getData();
}
2. Implémentation de IDao
   Rôle : Implémente l'interface IDao pour simuler une source de données.

Fichier : src/main/java/com/example/dao/DaoImpl.java

java
Copy
public class DaoImpl implements IDao {
@Override
public double getData() {
return 10.0; // Simule une donnée
}
}
3. Interface IMetier
   Rôle : Définit une méthode calcul() pour effectuer un calcul.

Fichier : src/main/java/com/example/metier/IMetier.java

java
Copy
public interface IMetier {
double calcul();
}
4. Implémentation de IMetier
   Rôle : Implémente l'interface IMetier en utilisant une dépendance de type IDao.

Fichier : src/main/java/com/example/metier/MetierImpl.java

java
Copy
public class MetierImpl implements IMetier {
private IDao dao;

    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {
        double data = dao.getData();
        return data * 2; // Exemple de calcul
    }
}
Partie 2 : Mini Framework d'Injection des Dépendances
1. Annotations Personnalisées
   @Component : Marque une classe comme un composant géré par le Framework.

@Inject : Indique qu'un champ doit être injecté automatiquement.

Fichiers :

src/main/java/com/example/framework/annotations/Component.java

src/main/java/com/example/framework/annotations/Inject.java

java
Copy
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Component {
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Inject {
}
2. Mini Framework
   Rôle : Charge les beans définis dans un fichier XML et injecte les dépendances.

Fichier : src/main/java/com/example/framework/MiniFramework.java

java
Copy
public class MiniFramework {
private Map<String, Object> beans = new HashMap<>();

    public void loadContext(String xmlFilePath) throws Exception {
        // Charge les beans depuis le fichier XML
        // Injecte les dépendances
    }

    public Object getBean(String beanId) {
        return beans.get(beanId);
    }
}
3. Fichier de Configuration XML
   Rôle : Définit les beans et leurs dépendances.

Fichier : src/main/resources/config.xml

xml
Copy
<beans>
<bean id="dao" class="com.example.dao.DaoImpl" />
<bean id="metier" class="com.example.metier.MetierImpl">
<property name="dao" ref="dao" />
</bean>
</beans>
Run HTML
Utilisation du Projet
1. Exécution avec le Mini Framework
   Fichier : Créez une classe Main.java pour tester le Framework.

java
Copy
public class Main {
public static void main(String[] args) throws Exception {
MiniFramework framework = new MiniFramework();
framework.loadContext("config.xml");

        IMetier metier = (IMetier) framework.getBean("metier");
        System.out.println("Résultat : " + metier.calcul());
    }
}
2. Exécution avec Spring
   Fichier de Configuration Spring : src/main/resources/applicationContext.xml

Fichier Principal : Créez une classe MainSpring.java pour tester Spring.

java
Copy
public class MainSpring {
public static void main(String[] args) {
ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
IMetier metier = (IMetier) context.getBean("metier");
System.out.println("Résultat : " + metier.calcul());
}
}
Comment Exécuter le Projet
Clonez le dépôt ou téléchargez les fichiers.

Ouvrez le projet dans un IDE (Eclipse, IntelliJ, etc.).

Compilez et exécutez la classe Main.java pour tester le mini Framework.

Compilez et exécutez la classe MainSpring.java pour tester Spring.