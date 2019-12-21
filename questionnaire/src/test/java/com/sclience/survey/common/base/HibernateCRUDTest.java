//package com.sclience.survey.common.base;
//
//import com.sclience.survey.common.base.entity.User;
//import com.sclience.survey.common.utils.template.HibernateUtil;
//import org.hibernate.*;
//import org.hibernate.criterion.Restrictions;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Date;
//import java.util.List;
//
///**
// * TODO
// *
// * @author 王克强
// * @version 1.0
// * @since 2019-12-05 16:08:01
// */
//public class HibernateCRUDTest {
//    @Autowired
//    private Session session;
//    /**
//     * 添加
//     */
//    @Test
//    public void testAdd(){
//        //创建对象
//        User user = new User("zujj", "123456", "zjingj",
//                "18595585381@163.com", new Date(), 1, 1, 1, 1,
//                new Date(), "zk", new Date(), "12345678911", "cdzz",
//                "1231", new Date(), "11111");
//        //获取session
//        Session session = HibernateUtil.createSession();
//        //开启事务
//        Transaction tx = session.beginTransaction();
//        //执行保存操作
//        session.save(user);
//        //提交事务
//        tx.commit();
//        //关闭相关资源
//        session.close();
//
//    }
//    /**
//     * 下面使用HQL,根据name进行模糊查询
//     */
//    @Test
//    public void testHQL(){
//        //获取session
//        Session session = HibernateUtil.createSession();
//        //开启事务
//        Transaction tx = session.beginTransaction();
//        //执行查询操作
//        //String id = "402893816ed5206a016ed5206dd10000";
//        String name = "zjingj";
//        Query query = session.createQuery("from com.sclience.survey.common.base.entity.User u where u.name like ?");
//        query.setString(0,"%"+name+"%");
//        List<User> users = query.list();
//        for (User user1 : users) {
//            System.out.println(user1.getName());
//        }
//        //提交事务
//        tx.commit();
//        //关闭相关资源
//        session.close();
//    }
//
//    /**
//     * 使用Criteria进行数据查询。
//     * 与HQL和SQL的区别是Criteria 完全是 面向对象的方式在进行数据查询，将不再看到有sql语句的痕迹.
//     * 除此之外，Criteria 还可以很方便的进行进行分页查询和获取总数。
//     */
//    @Test
//    public void testCriteria(){
//        //获取session
//        Session session = HibernateUtil.createSession();
//        //开启事务
//        Transaction tx = session.beginTransaction();
//        //核心代码
//        String name = "zjingj";
//        Criteria criteria = session.createCriteria(User.class);//1、通过session的createCriteria创建一个Criteria 对象
//        criteria.add(Restrictions.like("name","%"+name+"%"));//2. Criteria.add 增加约束。 在本例中增加一个对name的模糊查询(like)
//        List<User> list = criteria.list();//3、调用list()方法返回查询结果的集合
//        for (User user : list) {
//            System.out.println(user.getName());
//        }
//        //提交事务
//        tx.commit();
//        //关闭相关资源
//        session.close();
//    }
//    /**
//     * 通过标准SQL语句进行查询 。Hibernate依然保留了对标准SQL语句的支持，
//     * 在一些场合，比如多表联合查询，并且有分组统计函数的情况下，标准SQL语句依然是效率较高的一种选择。
//     *
//     * 使用标准SQL,根据name进行模糊查询：
//     */
//    @Test
//    public void testSQL(){
//        //获取session
//        Session session = HibernateUtil.createSession();
//        //开启事务
//        Transaction tx = session.beginTransaction();
//        //核心代码
//        String name = "zjingj";
//        SQLQuery query = session.createSQLQuery("select * from T_USER u where u.name like '%" + name + "%'");//使用Session的createSQLQuery方法执行标准SQL语句
//        /**
//         * 因为标准SQL语句有可能返回各种各样的结果，比如多表查询，分组统计结果等等。
//         * 不能保证其查询结果能够装进一个User对象中，所以返回的集合里的每一个元素是一个对象数组。
//         * 然后再通过下标把这个对象数组中的数据取出来。
//         */
//        List<Object[]> list = query.list();
//        for (Object[] objects : list) {
//            for (Object object : objects) {
//                System.out.print(object+"\t");
//            }
//            System.out.println();
//        }
//        //提交事务
//        tx.commit();
//        //关闭相关资源
//        session.close();
//    }
//    /**
//     * 根据 id 进行查询
//     */
//    @Test
//    public void testFindByRow(){
//        //获取session
//        Session session = HibernateUtil.createSession();
//        //开启事务
//        Transaction tx = session.beginTransaction();
//        //核心代码
//        String id = "402893816ed5206a016ed5206dd10000";
//        User user = (User) session.get(User.class, id);
//        System.out.println(user);
//        //提交事务
//        tx.commit();
//        //关闭相关资源
//        session.close();
//    }
//    /**
//     * 更新
//     */
//    @Test
//    public void testUpdate(){
//        //获取session
//        Session session = HibernateUtil.createSession();
//        //开启事务
//        Transaction tx = session.beginTransaction();
//        //核心代码
//        User user = (User) session.get(User.class, "402893816ed5206a016ed5206dd10000");
//        user.setName("你好呀");
//        session.update(user);
//        System.out.println(user.getName());
//        //提交事务
//        tx.commit();
//        //关闭相关资源
//        session.close();
//    }
//    /**
//     * 删除
//     */
//    @Test
//    public void testDelete(){
//        //获取session
//        Session session = HibernateUtil.createSession();
//        //开启事务
//        Transaction tx = session.beginTransaction();
//        //核心代码
//        User user = (User) session.get(User.class, "402893816ed5206a016ed5206dd10000");
//        session.delete(user);
//        System.out.println(user);
//        //提交事务
//        tx.commit();
//        //关闭相关资源
//        session.close();
//    }
//    /**
//     * 查询所有
//     */
//    @Test
//    public void testQueryAll(){
//        //获取session
//        Session session = HibernateUtil.createSession();
//        //开启事务
//        Transaction tx = session.beginTransaction();
//        //核心代码
//        Query query = session.createQuery("from com.sclience.survey.common.base.entity.User");
//        List<User> list = query.list();
//        for (User user : list) {
//            System.out.println(user.getName());
//        }
//        //提交事务
//        tx.commit();
//        //关闭相关资源
//        session.close();
//    }
//    /**
//     * 聚合函数的使用
//     */
//    @Test
//    public void testGetCount(){
//        //获取session
//        Session session = HibernateUtil.createSession();
//        //开启事务
//        Transaction tx = session.beginTransaction();
//        //核心的代码
//        Query query = session.createQuery("select count (id) from com.sclience.survey.common.base.entity.User");
//        Object o = query.uniqueResult();
//        System.out.println(o);
//        //提交事务
//        tx.commit();
//        //关闭相关资源
//        session.close();
//    }
//
//}
