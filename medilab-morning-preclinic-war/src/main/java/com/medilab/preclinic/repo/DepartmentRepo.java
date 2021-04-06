/**
 * 
 */
package com.medilab.preclinic.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medilab.preclinic.model.Department;

/**
 * @author nsanda
 *
 */
public interface DepartmentRepo extends JpaRepository<Department, Integer> {

}
