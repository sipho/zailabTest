package com.applesoft.dbmanager;

import com.applesoft.resources.RateServiceResource;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Sipho on 04/09/2017.
 */
public class ConnectionManager {

  private static final SessionFactory sessionFactory = buildSessionFactory();
  private static final Logger logger = LoggerFactory.getLogger(RateServiceResource.class);
  private static SessionFactory buildSessionFactory() {
    try {
      return new Configuration().configure().buildSessionFactory();
    } catch (Throwable ex) {
      logger.error("SessionFactory creation failed." + ex);
      throw new ExceptionInInitializerError(ex);
    }
  }

  public static SessionFactory getSessionFactory() {
    return sessionFactory;
  }

  public static void shutdown() {
    getSessionFactory().close();
  }
}
