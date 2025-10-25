package com.substring.chat.ChatApplication.entities;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class Message {
	
private String sender;
private String content;
private LocalDateTime timeStamp;
public Message(String sender, String content) {
	
	this.sender = sender;
	this.content = content;
	this.timeStamp=LocalDateTime.now();
}



}
