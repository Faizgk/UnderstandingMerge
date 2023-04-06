package com.highpeak.spring.springboot.courses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.highpeak.spring.springboot.topics.Topic;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {
    public List<Course> findByTopicId(String topicId);

}