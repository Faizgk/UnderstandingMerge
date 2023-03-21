package com.highpeak.spring.springboot;

import com.highpeak.spring.springboot.topics.Topic;
import com.highpeak.spring.springboot.topics.TopicRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.highpeak.spring.springboot.topics.TopicService;


import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;



import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


class SpringbootApplicationTests {

	@Mock
	 TopicRepository topicRepository;

	@InjectMocks
	TopicService topicService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void getAllTopicsTest(){
		when(topicRepository.findAll()).thenReturn(Stream.of(new Topic("001", "spring", "springlearn"),
				new Topic("002", "springboot", "springbootlearn")).collect(Collectors.toList()));

		assertEquals(2, topicService.getAllTopics().size());

	}

	@Test
	public void getAllTopicsTest2(){

		when(topicRepository.findAll()).thenReturn(Stream.of(new Topic("001", "spring", "springlearn"),
				new Topic("002", "springboot", "springbootlearn"), new Topic("003", "java", "javalearn"))
				.collect(Collectors.toList()));

		assertEquals(3, topicService.getAllTopics().size());

	}

	@Test
	public void getTopicTest(){

		Topic topic = new Topic("002","sprinboot", "springbootlearn");
		when(topicRepository.findById("002")).thenReturn(Optional.of(topic));

		assertEquals(Optional.of(topic), topicService.getTopic("002"));
	}


	@Test
	public void deleteTopicTest(){
		String id = "002";
		Topic topic = new Topic("002","sprinboot", "springbootlearn");
		topicRepository.deleteById(id);
		verify(topicRepository,times(1)).deleteById(id);

	}


	@Test
	public void deleteTopicTest2(){
		Topic topic = new Topic("002", "springboot", "springbootlearn");
		topicRepository.delete(topic);
		verify(topicRepository, times(1)).delete(topic);
	}

	@Test
	public void deleteTopicTest3(){
		Topic topic = new Topic("002", "springboot", "springbootlearn");
		topicRepository.deleteById("002");
		topicRepository.deleteById("002");
		verify(topicRepository, times(2)).deleteById("002");
	}
	@Test
	public void deleteTopicTest4(){
		String id = "002";
		topicRepository.deleteById(id);
		topicRepository.deleteById(id);
		verify(topicRepository, times(2)).deleteById("002");

	}
	@Test
	public void addTopicTest(){

		Topic topic = new Topic("002","sprinboot", "springbootlearn");

		topicRepository.save(topic);
		verify(topicRepository, times(1)).save(topic);

	}
	@Test
	public void addTopicTest2(){

		Topic topic = new Topic("002","sprinboot", "springbootlearn");

		topicRepository.save(topic);
		topicRepository.save(topic);

		verify(topicRepository, times(2)).save(topic);
	}


}
