package com.main.course;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CourseRepository extends CrudRepository<Course, Integer> {

	 List<Course> findByTopicId(Integer topicId);


	 @Query(value = "update Course c set c.name = :courseName, c.description = :courseDescription where c.id = :courseId and c.topic_id= :topicId", nativeQuery = true)
	 @Transactional
	 @Modifying
	 int updateCourseByTopicID(@Param("courseId") int id,@Param("topicId") int topicId,
							   @Param("courseName") String courseName, @Param("courseDescription") String courseDescription);
}
