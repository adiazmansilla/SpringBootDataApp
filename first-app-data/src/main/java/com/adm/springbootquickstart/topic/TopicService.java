package com.adm.springbootquickstart.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	List<Topic> lstTopics = new ArrayList<>(Arrays.asList(

			new Topic("Spring", "Spring Framework", "Spring Framework description"),
			new Topic("Java", "Java Core", "Java Description"),
			new Topic("javascript", "JavaScript", "Javascript Description")));

	public List<Topic> getAllTopics() {
		return lstTopics;
	}

	public Topic getTopic(String id) {
		return lstTopics.stream().filter(x -> x.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		lstTopics.add(topic);	
	}

	public void updateTopic(String id, Topic topic) {
		for(int i=0; i<lstTopics.size(); i++) {
			if(lstTopics.get(i).getId().equals(id)) {
				lstTopics.set(i, topic);
				return;
			}
		}
	}

	public void deleteTopic(String id) {
		lstTopics.removeIf(x->x.getId().equals(id));
	}

}
