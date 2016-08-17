/*
 * Copyright (c) 2015 Sohu TV. All rights reserved.
 */
package com.libing.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.libing.bean.Emp;
import com.libing.bean.EmpMapper;
import com.libing.dao.EmpDAO;

/**
 * <P>
 * Description:
 * </p>
 * @author "libing"
 * @version 1.0
 * @Date 2015年12月30日下午7:55:43
 */
public class JdbcEmpDAO1 extends JdbcDaoSupport implements EmpDAO {

    @Override
    public void save(Emp emp) {
        String sql = "insert into t_emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) "
                + "values(?,?,?,?,?,?,?,?)";
        Object[] params = {emp.getEmpno(), emp.getEname(), emp.getJob(), emp.getMgr(),
                emp.getHiredate(), emp.getSal(), emp.getComm(), emp.getDeptno()};
        super.getJdbcTemplate().update(sql, params);
    }

    @Override
    public void update(Emp emp) {
        String sql = "update t_emp set ename=?,job=?,mgr=?,hiredate=?,sal=?,comm=?,"
                + "deptno=? where empno=?";
        Object[] params = {emp.getEname(), emp.getJob(), emp.getMgr(), emp.getHiredate(),
                emp.getSal(), emp.getComm(), emp.getDeptno(), emp.getEmpno()};
        super.getJdbcTemplate().update(sql, params);
    }

    @Override
    public void delete(Long empno) {
        String sql = "delete from t_emp where empno=?";
        Object[] params = {empno};
        super.getJdbcTemplate().update(sql, params);
    }

    @Override
    public Emp findByEmpno(Long empno) {
        String sql = "select * from t_emp where empno=?";
        Object[] params = {empno};
        RowMapper<Emp> mapper = new EmpMapper();
        Emp emp = super.getJdbcTemplate().queryForObject(sql, params, mapper);
        return emp;
    }

    @Override
    public List<Emp> findAll() {
        String sql = "select * from t_emp";
        RowMapper<Emp> mapper = new EmpMapper();
        List<Emp> list = super.getJdbcTemplate().query(sql, mapper);
        return list;
    }

}
