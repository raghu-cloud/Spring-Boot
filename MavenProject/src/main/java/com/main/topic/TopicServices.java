package com.main.topic;

import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class TopicServices {

	List<Topic> topics = new ArrayList<>(
			Arrays.asList(new Topic("Spring", "spring framwork", "spring freame wrok descriptiosn"),
					new Topic("Java", "spring framwork", "spring freame wrok descriptiosn"),
					new Topic("Angular", "spring framwork", "spring freame wrok descriptiosn")));

	public List<Topic> getAllTopics() {
		return topics;
	}

	public Topic getTopicById(String id) {
//		Topic result=new Topic();
//		for(int i=0;i<topics.size();i++)
//		{
//			Topic t=topics.get(i);
//			if(t.getId().equalsIgnoreCase(id)) {
//				result =t;
//			}
//		}
//		return result;

		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();

	}

	public void addTopic(Topic t) {
		topics.add(t);
	}

	public void updateTopic(String id, Topic topic) {
		for (int i = 0; i < topics.size(); i++) {
			Topic topic1 = topics.get(i);
			if (topic1.getId().equalsIgnoreCase(id)) {
				topics.set(i, topic);
				return;
			}
		}
	}

	public void deleteTopicById(String id) {
//		for (int i = 0; i < topics.size(); i++) {
//			Topic topic = topics.get(i);
//			if (topic.getId().equalsIgnoreCase(id)) {
//				topics.remove(i);
//			}
//		}
		
		topics.removeIf(t -> t.getId().equalsIgnoreCase(id));
	}

	public void deleteAllTopics() {
		topics.removeAll(topics);
	}
	

}
