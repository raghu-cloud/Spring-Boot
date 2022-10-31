package com.main.topic;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicServices {
	
	@Autowired// it injects the courseRepository as it's initialized
	private TopicRepository topicRepository;

	

	public List<Topic> getAllTopics() {
		List<Topic> topics=new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
//		Iterator itr=topicRepository.findAll().iterator();
//		while(itr.hasNext()) {
//			Topic t=(Topic) itr.next();
//			topics.add(t);
//		}
		return topics;
	}

	public Topic getTopicById(int id) {
//		Topic result=new Topic();
//		Iterator itr=topicRepository.findAll().iterator();
//		while(itr.hasNext()) {
//			Topic t=(Topic) itr.next();
//			if(t.getId().equalsIgnoreCase(id))
//				result=t;
//		}
//		return result;
		if(topicRepository.findById(id).isPresent()) return topicRepository.findById(id).get();
		else return new Topic();
	}

	public Topic addTopic(Topic topic) {
		return topicRepository.save(topic);
	}

	public String  updateTopic(int id, Topic topic) {
		Topic exsTopic = topicRepository.findById(id).orElse(null);
		exsTopic.setName(topic.getName());
		exsTopic.setDescription(topic.getDescription());
		topicRepository.save(exsTopic);
		return exsTopic!=null ? "updated successfull" : "topic not found";
	}

	public String deleteTopicById(int id) {
		 if(topicRepository.existsById(id)){
			 topicRepository.deleteById(id);
			 return "deleted Successfull";
		 }
		 else return "Topic not present in DB";

	}

	public void deleteAllTopics() {
		topicRepository.deleteAll();
	}

	public List<Topic> topicsByName(String name){
		return topicRepository.findByName(name);
	}
	

}
