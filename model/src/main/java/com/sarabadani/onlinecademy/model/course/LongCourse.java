package com.sarabadani.onlinecademy.model.course;//import org.slf4j.Logger;

import com.sarabadani.onlinecademy.model.student.Student;

import java.util.List;

/**
 * @author: Soroosh Sarabadani
 * Date: 3/3/13
 * Time: 3:32 PM
 */

public class LongCourse extends AbstractCourse {
    public LongCourse() {
        super();
    }


    private Integer duration;
    private List<Integer> days;
    private String firstTime;
    private String endTime;

    @Override
    public void register(Student student) {


    }

    @Override
    public void unregister(Student student) {
        //To change body of implemented methods use File | Settings | File Templates.
    }


}
