/*
 * Copyright (c) 2015 Sohu TV. All rights reserved.
 */
package com.libing.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * <P>
 * Description:
 * </p>
 * @author "libing"
 * @version 1.0
 * @Date 2015年12月30日下午7:29:53
 */
public class EmpMapper implements RowMapper<Emp> {

    @Override
    public Emp mapRow(ResultSet rs, int rowIndex) throws SQLException {
        Emp emp = new Emp();
        emp.setEmpno(rs.getLong("EMPNO"));
        emp.setEname(rs.getString("ENAME"));
        emp.setJob(rs.getString("JOB"));
        emp.setMgr(rs.getLong("MGR"));
        emp.setHiredate(rs.getTimestamp("HIREDATE"));
        emp.setSal(rs.getDouble("SAL"));
        emp.setComm(rs.getDouble("COMM"));
        emp.setDeptno(rs.getLong("DEPTNO"));
        return emp;
    }

}

