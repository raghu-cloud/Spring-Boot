package com.main.course;



import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	CourseRepository courseRepository;



	public List<Course> getAllCourses(int id) {
		List<Course> courses=new ArrayList<>();
		courseRepository.findByTopicId(id).forEach(courses::add);
		return courses;
	}

	public Course getCourseById(int id) {
//		Course result=new Course();
//		Iterator<Course> itarator=courseRepository.findAll().iterator();
//		while(itarator.hasNext()) {
//			Course course=(Course) itarator.next();
//			if(course.getId().equalsIgnoreCase(id)) {
//				result=course;
//			}
//		}
//		return result;
		return courseRepository.existsById(id) ? courseRepository.findById(id).get() : new Course();
	}

	public void addCourse(Course course) {
		courseRepository.save(course);
	}

	public String updateCourse(int id,int topicId,Course course) {
		int response = courseRepository.updateCourseByTopicID(id,topicId,course.getName(),course.getDescription());
		return response==1?"Updated-Successfull":"Did not found course";
	}

	public void deleteCourseById(int courseId) {
		courseRepository.deleteById(courseId);
	}

	public void deleteAllCourses() {
		courseRepository.deleteAll();
	}

	public void deleAllCourseInsideGivenTopic(int id) {
		List<Course> courses=new ArrayList<>();
		courseRepository.findByTopicId(id).forEach(courses::add);
//		for(int i=0;i<courses.size();i++) {
//			Course course=courses.get(i);
//			String courseId=course.getId();
//			courseRepository.deleteById(courseId);
//		}
		courseRepository.deleteAll(courses);
	}

	

}
