package com.main.topic;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TopicRepository extends CrudRepository<Topic, Integer> {

    public List<Topic> findByName(String name);

    public List<Topic> findByNameLike(String name);

    public List<Topic> findByNameStartingWith(String name);

//    @Query("from Topic t where topicId=:id")
//+    public void getTopicById(@Param("id") String id);

}
