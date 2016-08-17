/*
 * Copyright (c) 2015 Sohu TV. All rights reserved.
 */
package com.libing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.libing.bean.Emp;
import com.libing.dao.EmpDAO;

/**
 * <P>
 * Description:
 * </p>
 * @author "libing"
 * @version 1.0
 * @Date 2015年12月30日下午10:59:21
 */
@Controller
public class EmpListController {

    @Autowired
    @Qualifier("jdbcEmpDao2")
    private EmpDAO empDAO;

    public EmpDAO getEmpdao() {
        return empDAO;
    }

    public void setEmpdao(EmpDAO empDAO) {
        this.empDAO = empDAO;
    }

    @RequestMapping("/emp/list")
    public String findAll(ModelMap model) {
        List<Emp> list = empDAO.findAll();
        model.addAttribute("emps", list);
        return "emp_list";
    }

    @RequestMapping("/emp/detail")
    public String detail(Long empno, ModelMap model) {
        Emp emp = empDAO.findByEmpno(empno);
        model.addAttribute("emp", emp);
        return "detail";
    }

    @RequestMapping("/emp/update")
    public String update(Emp emp) {
        empDAO.update(emp);
        return "redirect:/emp/list.do";
    }

    @RequestMapping("/emp/delete")
    public String delete(Long empno) {
        empDAO.delete(empno);
        return "redirect:/emp/list.do";
    }

}