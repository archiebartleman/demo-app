package com.myexample.controller.web;

import com.myexample.domain.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Controller("webEmployeeController")
@Slf4j
public class EmployeeController {

    @Autowired
    protected RestTemplate restTemplate;

    protected String serviceUrl = "http://localhost:2222";

    @RequestMapping(value = "/employees/{employeeNumber}")
    public String byNumber(Model model, @PathVariable("employeeNumber") Integer employeeNumber) {
        Employee employee = null;
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<String>(headers);

            ResponseEntity<Employee> response = restTemplate.exchange(serviceUrl + "/employees/details/" + employeeNumber,
                    HttpMethod.GET, entity, Employee.class);
            employee = response.getBody();
            log.info("EMPLOYEE = " + employee.toString());
        } catch (Exception e) {
            log.error("EXCEPTION", e);
        }
        model.addAttribute("employee", employee);
        return "employee";
    }

}
