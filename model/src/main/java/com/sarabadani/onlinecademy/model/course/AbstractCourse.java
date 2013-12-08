package com.sarabadani.onlinecademy.model.course;//import org.slf4j.Logger;

import com.sarabadani.onlinecademy.model.Lecturer;

import java.util.Date;

/**
 * @author: Soroosh Sarabadani
 * Date: 3/3/13
 * Time: 8:02 AM
 */

public abstract class  AbstractCourse {
    private final Date createDate;
    private Date startDate;
    private Date endDate;
    private String title;
    private String description;
    private Integer price;
    private Integer capacity;
//    private List<Student> registeredStudents;
    private Lecturer lecturer;

    public AbstractCourse() {
        this.createDate = new Date();
    }

//    public abstract void register(Student student);

//    public abstract void unregister(Student student);

}
