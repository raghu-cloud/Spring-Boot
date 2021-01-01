package com.main.course;



import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	CourseRepository courseRepository;

	public List<Course> getAllCourses(String id) {
		List<Course> courses=new ArrayList<>();
		courseRepository.findByTopicId(id).forEach(courses::add);
		return courses;
	}

	public Course getCourseById(String id) {
		Course result=new Course();
		Iterator<Course> itarator=courseRepository.findAll().iterator();
		while(itarator.hasNext()) {
			Course course=(Course) itarator.next();
			if(course.getId().equalsIgnoreCase(id)) {
				result=course;
			}
		}
		return result;
	}

	public void addCourse(Course course) {
		courseRepository.save(course);
	}

	public void updateCourse(Course course) {
		courseRepository.save(course);
	}

	public void deleteCourseById(String courseId) {
		courseRepository.deleteById(courseId);
	}

	public void deleteAllCourses() {
		courseRepository.deleteAll();
	}

	public void deleAllCourseInsideGivenTopic(String id) {
		List<Course> courses=new ArrayList<>();
		courseRepository.findByTopicId(id).forEach(courses::add);
		for(int i=0;i<courses.size();i++) {
			Course course=courses.get(i);
			String courseId=course.getId();
			courseRepository.deleteById(courseId);
		}
	}

	

}
