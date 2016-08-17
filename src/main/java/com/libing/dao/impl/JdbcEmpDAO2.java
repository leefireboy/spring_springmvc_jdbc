/*
 * Copyright (c) 2015 Sohu TV. All rights reserved.
 */
package com.libing.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.libing.bean.Emp;
import com.libing.bean.EmpMapper;
import com.libing.dao.EmpDAO;

/**
 * <P>
 * Description:
 * </p>
 * @author "libing"
 * @version 1.0
 * @Date 2015年12月30日下午8:25:14
 */
public class JdbcEmpDAO2 implements EmpDAO {

    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public void save(Emp emp) {
        String sql = "insert into t_emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) "
                + "values(?,?,?,?,?,?,?,?)";
        Object[] params = {emp.getEmpno(), emp.getEname(), emp.getJob(), emp.getMgr(),
                emp.getHiredate(), emp.getSal(), emp.getComm(), emp.getDeptno()};
        template.update(sql, params);
    }

    @Override
    public void update(Emp emp) {
        String sql = "update t_emp set ename=?,job=?,mgr=?,hiredate=?,sal=?,comm=?,"
                + "deptno=? where empno=?";
        Object[] params = {emp.getEname(), emp.getJob(), emp.getMgr(), emp.getHiredate(),
                emp.getSal(), emp.getComm(), emp.getDeptno(), emp.getEmpno()};
        template.update(sql, params);
    }

    @Override
    public void delete(Long empno) {
        String sql = "delete from t_emp where empno=?";
        Object[] params = {empno};
        template.update(sql, params);
    }

    @Override
    public Emp findByEmpno(Long empno) {
        String sql = "select * from t_emp where empno=?";
        Object[] params = {empno};
        RowMapper<Emp> mapper = new EmpMapper();
        Emp emp = template.queryForObject(sql, params, mapper);
        return emp;
    }

    @Override
    public List<Emp> findAll() {
        String sql = "select * from t_emp";
        RowMapper<Emp> mapper = new EmpMapper();
        List<Emp> list = template.query(sql, mapper);
        return list;
    }

}
