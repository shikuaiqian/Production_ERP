package com.cskaoyan.service.person;

import java.util.Map;

public interface EmployeeService {
    public Map selectEmployeesByPage(String page, String rows);
}
