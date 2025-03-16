package com.mouad.framework;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class MiniFramework {
    private Map<String, Object> beans = new HashMap<>();

    public void loadContext(String xmlFilePath) throws Exception {
        // Charger le fichier XML
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(xmlFilePath);

        // Parcourir les beans
        NodeList beanNodes = document.getElementsByTagName("bean");
        for (int i = 0; i < beanNodes.getLength(); i++) {
            Node node = beanNodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String id = element.getAttribute("id");
                String className = element.getAttribute("class");
                Object instance = Class.forName(className).getDeclaredConstructor().newInstance();
                beans.put(id, instance);
            }
        }

        // Injecter les dépendances
        for (String beanId : beans.keySet()) {
            Object bean = beans.get(beanId);
            for (Field field : bean.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(Inject.class)) {
                    field.setAccessible(true);
                    String fieldName = field.getName();
                    Object dependency = beans.get(fieldName);
                    if (dependency != null) {
                        field.set(bean, dependency);
                    }
                }
            }
        }
    }

    public Object getBean(String beanId) {
        return beans.get(beanId);
    }
}