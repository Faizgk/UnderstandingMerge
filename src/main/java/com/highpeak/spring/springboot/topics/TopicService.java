package com.highpeak.spring.springboot.topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TopicService {



    @Autowired
    private TopicRepository topicRepository;

/*    private List<Topic> topics = new ArrayList<Topic>(Arrays.asList(new Topic("001", "java", "java Class"),
            new Topic("002", "python", "python class")));   */


        public List<Topic> getAllTopics(){

            List<Topic> topics = new ArrayList<>();
        //return topics;
            topicRepository.findAll().forEach(topics::add);
            return topics;
        }
        public Optional<Topic> getTopic(String id){

/*    try{
                return  topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();

            }catch (NoSuchElementException e){
                System.out.println("No Such Element Found");

                return null;
            }   */
           return topicRepository.findById(id);


        }

        public void addTopic(Topic topic){
            //topics.add(topic);
            topicRepository.save(topic);
        }

        public void updateTopic(String id, Topic topic){
/*
            for (int i=0;i<=topics.size()-1;i++){
                if(topics.get(i).getId().equals(id)){
                    topics.set(i, topic);
                }

            }*/
            topicRepository.save(topic);

        }

        public void deleteTopic(String id){

            //topics.removeIf(t -> t.getId().equals(id));
            topicRepository.deleteById(id);
        }
}
