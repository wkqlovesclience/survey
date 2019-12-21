package com.sclience.survey.common.base.beans;

import com.sclience.survey.common.utils.template.HibernateUtil;
import org.hibernate.Session;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author 王克强
 * @version 1.0
 * @since 2019-12-05 22:50:09
 */
@Configuration
public class MyBeans {
    @Bean
    public Session getSession(){
        return  HibernateUtil.createSession();

    }
}
