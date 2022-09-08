package com.zaurtregulov.spring.mvc_hibernate_aop.controller;

import com.zaurtregulov.spring.mvc_hibernate_aop.entity.Employee;
import com.zaurtregulov.spring.mvc_hibernate_aop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MYController {

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("empId")int id){

    employeeService.deleteEmployee(id);

    return "redirect:/";
}



    @RequestMapping  ("/updateInfo")
    public String updateEmployee(@RequestParam("empId")int id,Model model){

        Employee employee=employeeService.getEnployee(id);

        model.addAttribute("employee",employee);

                return "employee-info";
    }


    @RequestMapping("/saveEmployee")
    public String SaveEmployee(@ModelAttribute ("employee") Employee employee){

        employeeService.saveEmployee(employee);

        return "redirect:/";
    }

    @RequestMapping("/addNewEmployee")
    public String AddNewEmployee(Model model){

        Employee employee=new Employee();

        model.addAttribute("employee",employee);

         return "employee-info";
    }
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/")
    public String ShowAllEmployees(Model model){

        List<Employee>allEmployees= employeeService.getAllEmployees();

        model.addAttribute("allEmps",allEmployees);

        return "all-employees";
}
}
