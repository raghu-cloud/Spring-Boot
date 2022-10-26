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

	public Topic getTopicById(String id) {
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

	public String  updateTopic(String id, Topic topic) {
		List<Topic> topics=new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		StringBuilder res=new StringBuilder();
		int indexOfOldTpc = topics.indexOf(topicRepository.existsById(id) ? topicRepository.findById(id).get(): null);
		if(indexOfOldTpc !=-1){
			topics.set(indexOfOldTpc, topic);
			res.append("Update success") ;
		}else res.append("update failed");
		topicRepository.deleteAll();
		topicRepository.saveAll(topics);
		return res.toString();
	}

	public String deleteTopicById(String id) {
		 if(topicRepository.existsById(id)){
			 topicRepository.deleteById(id);
			 return "deleted Successfull";
		 }
		 else return "Topic not present in DB";

	}

	public void deleteAllTopics() {
		topicRepository.deleteAll();
	}
	

}
