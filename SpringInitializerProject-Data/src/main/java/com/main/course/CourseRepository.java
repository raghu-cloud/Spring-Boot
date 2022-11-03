package com.main.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Integer> {

	 List<Course> findByTopicId(Integer topicId);
}
