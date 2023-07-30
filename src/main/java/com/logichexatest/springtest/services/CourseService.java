package com.logichexatest.springtest.services;

import com.logichexatest.springtest.entitiy.Course;

import java.util.List;

public interface CourseService {
    public List<Course> getCourses();
    public Course getCourse(long courseId);
    public Course addCourse(Course course);
    public  Course updatecourse(Course course);
    public void deleteCourse(Long courseId);
}
