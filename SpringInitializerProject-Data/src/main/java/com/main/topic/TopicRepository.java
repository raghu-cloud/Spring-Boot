package com.main.topic;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TopicRepository extends CrudRepository<Topic, Integer> {

     List<Topic> findByName(String name);

     List<Topic> findByNameLike(String name);

     List<Topic> findByNameStartingWith(String name);

    @Query("select t from Topic t")
     List<Topic> getTopics();

    //use @modifying annotation for update/delete based functionalities and return type of @modifying method will only be void or int or Integer
    @Modifying
    @Transactional
    @Query("update Topic t set t.name = :name, t.description = :desc where t.id = :id")
     int updateTopic(@Param("id") int id, @Param("name") String name, @Param("desc") String desc);

    @Query(value="select * from Topic where id = :id", nativeQuery = true)
     Topic getTopicByIdNativeQuery(@Param("id")int id);

}
