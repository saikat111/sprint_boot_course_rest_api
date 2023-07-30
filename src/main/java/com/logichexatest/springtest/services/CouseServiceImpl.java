package com.logichexatest.springtest.services;
import com.logichexatest.springtest.entitiy.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CouseServiceImpl implements CourseService{
    List<Course> list ;
    public CouseServiceImpl(){
        list = new ArrayList<>();
        list.add(new Course(125, "java", "this is basic java"));
        list.add(new Course(126, "python", "this is basic python"));
    }
    @Override
    public List<Course> getCourses() {
        return list;
    }

    @Override
    public Course getCourse(long courseId) {
        Course c = null;
        for(Course  course :list){
            if(course.getId()==courseId){
                c = course;
                break;
            }
        }
        return c;
    }

    @Override
    public Course addCourse(Course course) {
        list.add(course);
        return course;
    }

    @Override
    public Course updatecourse( Course course) {
       list.forEach(e ->{
           if(e.getId() == course.getId()){
             e.setTitle(course.getTitle());
             e.setDiscription(course.getDiscription());
           }
       });
        return course;
    }

    @Override
    public void deleteCourse(Long courseId) {
        list = this.list.stream().filter(e -> e.getId()!=courseId).collect(Collectors.toList());
    }

}
