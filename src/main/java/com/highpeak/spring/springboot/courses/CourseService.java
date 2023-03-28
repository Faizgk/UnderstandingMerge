package com.highpeak.spring.springboot.courses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.highpeak.spring.springboot.topics.Topic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    public CourseRepository courseRepository;

/*    private List<Topic> topics = new ArrayList<Topic>(Arrays.asList(new Topic("001", "java", "java Class"),
            new Topic("002", "python", "python class")));   */


    public List<Course> getAllCourses(String topicId)
    {
        List<Course> courses=new ArrayList<>();
        courseRepository.findByTopicId(topicId)
                .forEach(courses::add);
        return courses;
    }

        public Optional<Course> getCourse(String courseId){

/*    try{
                return  topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();

            }catch (NoSuchElementException e){
                System.out.println("No Such Element Found");

                return null;
            }   */
           return courseRepository.findById(courseId);


        }

        public void addCourse(Course course){
            //topics.add(topic);
            courseRepository.save(course);
        }

        public void updateCourse(Course course){
/*
            for (int i=0;i<=topics.size()-1;i++){
                if(topics.get(i).getId().equals(id)){
                    topics.set(i, topic);
                }

            }*/
            courseRepository.save(course);

        }

        public void deleteCourse(String id){

            //topics.removeIf(t -> t.getId().equals(id));
            courseRepository.deleteById(id);
        }


}
