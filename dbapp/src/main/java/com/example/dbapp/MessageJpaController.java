package com.example.dbapp;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST処理
 */
@RestController
@RequestMapping("messagesjpa")
public class MessageJpaController {

	@Autowired
	MessageRepository messageRepository;

	/**
	 * 
	 * 呼び出し方法
	 * curl -D - http://localhost:8080/messagesjpa/
	 * @param message
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<Message> getMessages() {
		return messageRepository.findAll();
	}

	/**
	 * 
	 * 呼び出し方法
	 * curl -D - -H "Content-type:application/json" -X POST -d '{"text":"abcdefg"}'  http://localhost:8080/messagesjpa/
	 * @param message
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public Message postMessages(@RequestBody Message message) {

		return messageRepository.save(message);
	}
}
