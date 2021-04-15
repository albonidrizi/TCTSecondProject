package com.tct.SecondProject.controller;

import com.tct.SecondProject.model.AllRooms;
import com.tct.SecondProject.model.Room;
import com.tct.SecondProject.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RoomControler {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("/value")
    public AllRooms getAll(){
        AllRooms allRooms = new AllRooms();
        List<Room> rooms = roomRepository.findAll();
     return allRooms;
    }


}
