/*
 * Copyright (c) 2015 Sohu TV. All rights reserved.
 */
package com.libing.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.libing.bean.Emp;
import com.libing.dao.EmpDAO;

/**
 * <P>
 * Description:
 * </p>
 * @author "libing"
 * @version 1.0
 * @Date 2015年12月30日下午8:14:45
 */
public class Test1 {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        String conf = "spring.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
//        System.out.println(ac);
        EmpDAO empDao = ac.getBean("jdbcEmpDao1", EmpDAO.class);
        List<Emp> list = empDao.findAll();
        for (Emp emp : list) {
            System.out.println(emp.getEmpno() + " " + emp.getEname());
        }
    }

}

