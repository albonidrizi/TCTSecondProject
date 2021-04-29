package com.tct.SecondProject.controller;

import com.tct.SecondProject.model.FindAll;
import com.tct.SecondProject.model.Room;
import com.tct.SecondProject.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("/rooms")
    public FindAll<Room> getAll() {
        FindAll<Room> allRooms = new FindAll<>();
        List<Room> rooms = roomRepository.findAll();

        allRooms.setItems(rooms);
        return allRooms;
    }


    @PostMapping("/rooms")
    public void createRoom(@RequestBody Room room) {
        roomRepository.save(room);
    }

}
