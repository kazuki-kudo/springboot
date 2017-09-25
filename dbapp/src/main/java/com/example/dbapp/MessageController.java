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
@RequestMapping("messages")
public class MessageController {

	@Autowired
	JdbcTemplate jdbcTemplate;

	final java.util.List<Message> messages = new CopyOnWriteArrayList<>();

	/**
	 * 
	 * 呼び出し方法
	 * curl -D - http://localhost:8080/messages/
	 * @param message
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<Message> getMessages() {
		return jdbcTemplate.query("SELECT text FROM messages ORDER BY id", (rs, i) -> {
			Message m = new Message();
			m.setText(rs.getString("text"));
			return m;
		});
	}

	/**
	 * 
	 * 呼び出し方法
	 * curl -D - -H "Content-type:application/json" -X POST -d '{"text":"abcdefg"}'  http://localhost:8080/messages/
	 * @param message
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public Message postMessages(@RequestBody Message message) {
		jdbcTemplate.update("INSERT INTO messages(text) VALUES (?)",message.getText());
		return message;
	}
}
