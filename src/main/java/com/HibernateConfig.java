package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public enum HibernateConfig {

    INSTANCE;

    public SessionFactory getSessionFactory() {

        //Wczytywanie konfiguracji

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        MetadataSources sources = new MetadataSources(registry);
        Metadata metadata = sources.getMetadataBuilder().build();
        return metadata.getSessionFactoryBuilder().build();

    }
}

