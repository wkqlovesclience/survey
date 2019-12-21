//package com.sclience.survey.common;
//
//import com.sclience.survey.common.base.entity.User;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.classic.Session;
//import org.junit.Test;
//
//import java.util.Date;
//
///**
// * TODO
// *
// * @author 王克强
// * @version 1.0
// * @since 2019-12-04 23:22:55
// */
//public class TestHibernate {
//    @Test
//    public void test(){
//        //创建对象
//        User user = new User("wkq", "123456", "wqangkeqiang",
//                "18595585871@163.com", new Date(), 1, 1, 1, 1,
//                new Date(), "zk", new Date(), "12345678911", "cdzz",
//                "1231", new Date(), "123456");
//        //获取加载配置管理类
//
//        Configuration configuration = new Configuration();
//
//        //不给参数就默认加载hibernate.cfg.xml文件，
//        configuration.configure();
//
//        //创建Session工厂对象
//        SessionFactory factory = configuration.buildSessionFactory();
//
//        //得到Session对象
//        Session session = factory.openSession();
//
//        //使用Hibernate操作数据库，都要开启事务,得到事务对象
//        Transaction transaction = session.getTransaction();
//
//        //开启事务
//        transaction.begin();
//
//        //把对象添加到数据库中
//        session.save(user);
//
//        //提交事务
//        transaction.commit();
//
//        //关闭Session
//        session.close();
//    }
//
//    public static void main(String[] args) {
//       //创建对象
//        User user = new User("wkq", "123456", "wqangkeqiang",
//                "18595585871@163.com", new Date(), 1, 1, 1, 1,
//                new Date(), "zk", new Date(), "12345678911", "cdzz",
//                "1231", new Date(), "123456");
//        //获取加载配置管理类
//
//        Configuration configuration = new Configuration();
//
//        //不给参数就默认加载hibernate.cfg.xml文件，
//        configuration.configure();
//
//        //创建Session工厂对象
//        SessionFactory factory = configuration.buildSessionFactory();
//
//        //得到Session对象
//        Session session = factory.openSession();
//
//        //使用Hibernate操作数据库，都要开启事务,得到事务对象
//        Transaction transaction = session.getTransaction();
//
//        //开启事务
//        transaction.begin();
//
//        //把对象添加到数据库中
//        session.save(user);
//
//        //提交事务
//        transaction.commit();
//
//        //关闭Session
//        session.close();
//    }
//}
