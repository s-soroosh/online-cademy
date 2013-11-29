package com.sarabadani.commons.repository;

import com.sarabadani.onlinecademy.model.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: Soroosh Sarabadani
 * Date: 3/8/13
 * Time: 2:41 PM
 */
public interface StudentRepository extends JpaRepository<Student,Long> {
}
