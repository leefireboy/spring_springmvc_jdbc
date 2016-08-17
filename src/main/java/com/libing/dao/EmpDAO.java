/*
 * Copyright (c) 2015 Sohu TV. All rights reserved.
 */
package com.libing.dao;

import java.util.List;

import com.libing.bean.Emp;

/**
 * <P>
 * Description:TODO
 * </p>
 * @author "libing"
 * @version 1.0
 * @Date 2015年12月30日下午7:52:57
 */
public interface EmpDAO {
    public void save(Emp emp);
    public void update(Emp emp);
    public void delete(Long empno);
    public Emp findByEmpno(Long empno);
    public List<Emp> findAll();
}

