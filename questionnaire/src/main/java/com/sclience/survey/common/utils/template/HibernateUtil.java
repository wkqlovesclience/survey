package com.sclience.survey.common.utils.template;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * TODO
 *
 * @author 王克强
 * @version 1.0
 * @since 2019-12-05 16:05:11
 */
public class HibernateUtil {
    private static SessionFactory factory;

    static{
        // 创建Configuration对象
        Configuration configuration = new Configuration();
        configuration.configure();
        factory = configuration.buildSessionFactory();
    }

    public static Session createSession(){
        return factory.openSession();
    }

}
