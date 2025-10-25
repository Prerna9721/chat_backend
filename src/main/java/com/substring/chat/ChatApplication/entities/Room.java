package com.substring.chat.ChatApplication.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Document(collection="roooms")
@Getter
@Setter
@NoArgsConstructor
public class Room {
	@Id
	private String id; //momgo db unique identifier
	private String roomId;
	
	private List<Message>messages=new ArrayList<>();
	

}
