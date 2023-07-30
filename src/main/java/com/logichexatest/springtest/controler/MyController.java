package com.logichexatest.springtest.controler;
import com.logichexatest.springtest.entitiy.Course;
import com.logichexatest.springtest.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {
    @Autowired
    private CourseService courseService;
    @GetMapping("/home")
    public String home(){
        return "This is home";
    }
    //get the courses
    @GetMapping("/courses")
    public List<Course> getCourses(){
        return this.courseService.getCourses();
    }
    @GetMapping("courses/{courseId}")
    public  Course getCourse(@PathVariable String courseId){
        return this.courseService.getCourse(Long.parseLong(courseId));
    }
    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course){
        return this.courseService.addCourse(course);
    }
    @PutMapping("/courses/{courseId}")
    public Course updatecourse(@PathVariable String courseId,@RequestBody Course course){
        return this.courseService.updatecourse(Long.parseLong(courseId),course);
    }

}
