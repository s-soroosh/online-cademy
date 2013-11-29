package com.sarabadani.onlinecademy.service;//import org.slf4j.Logger;
//import com.samenea.commons.component.utils.log.LoggerFactory;

import com.sarabadani.onlinecademy.model.course.AbstractCourse;

import java.util.List;

/**
 * @author: Soroosh Sarabadani
 * Date: 3/3/13
 * Time: 5:06 PM
 */

public interface CourseService {
    List<AbstractCourse> findAllFreeCourses();
}
