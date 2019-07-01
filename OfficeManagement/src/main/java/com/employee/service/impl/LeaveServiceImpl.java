package com.employee.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employee.model.Employee;
import com.employee.model.Leave;
import com.employee.repository.LeaveRepository;
import com.employee.services.LeaveService;

@Component
public class LeaveServiceImpl implements LeaveService {
	@Autowired
	private LeaveRepository repository;

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;

	public Leave creates(long id, Leave leave) {
		Optional<Employee> exist = null;
		exist = employeeServiceImpl.getid(id);

		if (exist.isPresent()) {
			leave.setEmployeeId(id);
			return repository.save(leave);

		} else {
			leave.setMsg("Employee not exist");
			return leave;
		}
	}

	public List<Leave> getid(long employeeId) {
		return repository.findByEmployeeId(employeeId);
	}

}
