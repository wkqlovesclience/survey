package com.sclience.survey.common.base.beans;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author 王克强
 * @version 1.0
 * @since 2019-12-05 22:50:09
 */
@Component
public class MyBeans {

    @Bean(name = "sessionFactory")
    public static SessionFactory sessionFactory(){
        Configuration configuration = new Configuration();
        configuration.configure();
        return configuration.buildSessionFactory();

    }

    @Bean(name = "session")
    public static Session createSession(){
        return sessionFactory().openSession();
        //return sessionFactory().getCurrentSession();
    }
}
