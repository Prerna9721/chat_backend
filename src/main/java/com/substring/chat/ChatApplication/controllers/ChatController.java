package com.substring.chat.ChatApplication.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import com.substring.chat.ChatApplication.config.AppConstants;
import com.substring.chat.ChatApplication.entities.Message;
import com.substring.chat.ChatApplication.entities.Room;
import com.substring.chat.ChatApplication.entities.Room;
import com.substring.chat.ChatApplication.payload.MessageRequest;
import com.substring.chat.ChatApplication.repositories.RoomRepository;

@Controller
@CrossOrigin(AppConstants.FRONT_END_BASE_URL)
public class ChatController {
	@Autowired
	private RoomRepository roomRepository;

	public ChatController(RoomRepository roomRepository) {

		this.roomRepository = roomRepository;
	}
	//for sending and receiving messages
	@MessageMapping("/sendMessage/{roomId}")
	@SendTo("/topic/room/{roomId}")
	public Message sendMessages(
		@DestinationVariable String roomId,
			@RequestBody MessageRequest request) {
		
		Room room=roomRepository.findByRoomId(request.getRoomId());
		
		Message message=new Message();
		message.setContent(request.getContent());
		message.setSender(request.getSender());
		message.setTimeStamp(LocalDateTime.now());
		
		
		if(room!=null) {
			room.getMessages().add(message);
			roomRepository.save(room);
		}else {
			throw new RuntimeException("Room Not found");
		}
		return message;
		
	}

}
