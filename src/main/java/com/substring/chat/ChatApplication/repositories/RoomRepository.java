package com.substring.chat.ChatApplication.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.substring.chat.ChatApplication.entities.Room;

public interface RoomRepository extends MongoRepository<Room,String> {
	
	//get room using room id
	Room findByRoomId(String roomId);

}
