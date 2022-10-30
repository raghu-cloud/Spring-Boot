package com.main.topic;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, Integer> {

//    @Query("from Topic t where topicId=:id")
//+    public void getTopicById(@Param("id") String id);

}
