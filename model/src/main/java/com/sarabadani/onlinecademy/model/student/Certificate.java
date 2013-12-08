package com.sarabadani.onlinecademy.model.student;//import org.slf4j.Logger;
//import com.samenea.commons.component.utils.log.LoggerFactory;

import com.sarabadani.onlinecademy.model.course.AbstractCourse;

import java.util.Date;

/**
 * @author: Soroosh Sarabadani
 * Date: 3/3/13
 * Time: 8:03 AM
 */

public class Certificate {
    private final AbstractCourse course;

    private final Date publishedDate;
    private final Rank rank;

    public Certificate(AbstractCourse course, Rank rank) {
        this.publishedDate = new Date();
        this.course = course;
//        this.student = student;
        this.rank = rank;
    }
}
