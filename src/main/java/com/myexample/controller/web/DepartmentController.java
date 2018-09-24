package com.myexample.controller.web;

import com.myexample.domain.Department;
import com.myexample.domain.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller("webDepartmentController")
@Slf4j
public class DepartmentController {
    @Autowired
    protected RestTemplate restTemplate;

    protected String serviceUrl = "http://localhost:2222";

    @RequestMapping(value = "/departments/all")
    public String allDepts(Model model) {
        List<Department> departments = null;
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(new MediaType[]{MediaType.APPLICATION_JSON}));
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<String>(headers);

            ResponseEntity<List<Department>> response = restTemplate.exchange(serviceUrl + "/departments/details/all",
                    HttpMethod.GET, entity, new ParameterizedTypeReference<List<Department>>() {
                    });
            departments = response.getBody();
        } catch (Exception e) {
            log.error("EXCEPTION", e);
        }
        model.addAttribute("departments", departments);
        return "departments";
    }

}
