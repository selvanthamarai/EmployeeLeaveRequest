package com.employee.service.impl;

import java.util.List;
import java.util.Optional;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.employee.model.Employee;

import com.employee.repository.EmployeeRepository;
import com.employee.services.EmployeeService;

@Component
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee insertDetail(Employee employee) throws ServiceException {
		return employeeRepository.save(employee);
	}

	public List<Employee> get() {
		return employeeRepository.findAll();
	}

	public Optional<Employee> getid(long id) {
		return employeeRepository.findById(id);
	}

	public Employee update(long id, Employee employee) {
		employee.setId(id);
		return employeeRepository.save(employee);

	}

	public void delete(long id) {
		employeeRepository.deleteById(id);

	}

}
