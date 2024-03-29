package com.main.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.main.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	CourseService courseService=new CourseService();
	
	
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable int id) {
		return courseService.getAllCourses(id);
	}
	
	@RequestMapping("/courses/{id}")
	public Course getCourseById(@PathVariable int id) {
		return courseService.getCourseById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/topics/{id}/addCourse")
	public void addCourse(@PathVariable int id, @RequestBody Course course) {
		course.setTopic(new Topic(id,"",""));
		courseService.addCourse(course);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/topics/{topicId}/updateCourse/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable int topicId, @PathVariable int id) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.updateCourse(course);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/deleteCourse/{id}")
	public void deleteCourseById(@PathVariable int id) {
		courseService.deleteCourseById(id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/topics/{id}/deleteAllCourse")
	public void deleteAllCourseInsideGivenTopic(@PathVariable int id) {
		courseService.deleAllCourseInsideGivenTopic(id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/deleteAllCourse")
	public void deleteAllCourses() {
		courseService.deleteAllCourses();
	}
}
