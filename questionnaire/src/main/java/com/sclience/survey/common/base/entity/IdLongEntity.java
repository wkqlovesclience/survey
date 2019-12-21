package com.sclience.survey.common.base.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 统一定义id的entity基类.
 *
 * 基类统一定义id的属性名称、数据类型、列名映射及生成策略.
 * 子类可重载getId()函数重定义id的列名映射和生成策略.
 *
 */
//JPA Entity基类的标识
@MappedSuperclass
public abstract class IdLongEntity {

    protected Long id;

    @Id
    /**
     * AUTO：主键由程序控制。
     * IDENTITY：主键由数据库自动生成（主要是自动增长型） ；
     * SEQUENCE：根据底层数据库的序列来生成主键，条件是数据库支持序列（类似oracle）；
     * TABLE：使用一个特定的数据库表格来保存主键.
     */
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
