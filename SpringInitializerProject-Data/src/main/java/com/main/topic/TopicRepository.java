package com.main.topic;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicRepository extends CrudRepository<Topic, Integer> {

    public List<Topic> findByName(String name);

    public List<Topic> findByNameLike(String name);

    public List<Topic> findByNameStartingWith(String name);

    @Query("select t from Topic t")
    public List<Topic> getTopics();

}
