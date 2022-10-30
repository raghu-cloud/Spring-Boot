package com.main.topic;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	@Autowired
	TopicServices topicService = new TopicServices();

	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/topics/{id}")
	public Topic getTopicById(@PathVariable("id") int id) {
		return topicService.getTopicById(id);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/topics")
	public Topic addTopic(@RequestBody Topic t) {
		return topicService.addTopic(t);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	public String updateTopic(@PathVariable int id, @RequestBody Topic topic) {
		return topicService.updateTopic(id, topic);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
	public String deletTopicById(@PathVariable int id) {
		return topicService.deleteTopicById(id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/delete")
	public void deleteAllTopics() {
		topicService.deleteAllTopics();
	}

}
