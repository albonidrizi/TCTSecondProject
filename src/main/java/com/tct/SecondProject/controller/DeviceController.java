package com.tct.SecondProject.controller;

import com.tct.SecondProject.model.Device;
import com.tct.SecondProject.model.DeviceApiModel;
import com.tct.SecondProject.model.FindAll;
import com.tct.SecondProject.model.Room;
import com.tct.SecondProject.repository.DeviceRepository;
import com.tct.SecondProject.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DeviceController {

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("/devices")
    public FindAll<DeviceApiModel> findAll(@RequestParam(required = false , defaultValue = "0") Integer pageNumber,
                                           @RequestParam(required = false , defaultValue = "5" ) Integer pageSize) {

        Pageable pageable = PageRequest.of(pageNumber , pageSize);

        FindAll<DeviceApiModel> response = new FindAll<>();
        Page<Device> devices = deviceRepository.findAll(pageable);

        List<DeviceApiModel> models = devices.stream()
                .map(DeviceApiModel::new)
                .collect(Collectors.toList()) ;

        response.setItems(models);
        response.setPage(pageNumber);
        response.setTotal((int) deviceRepository.count());
        return response;
    }

    @PostMapping("/devices")
    public void createDevice(@RequestBody DeviceApiModel deviceApiModel) {
        Room room = roomRepository.getOne(deviceApiModel.getRoomId());

        Device device = new Device();
        device.setName(deviceApiModel.getName());
        device.setOn(deviceApiModel.getIsOn());
        device.setRoom(room);
        deviceRepository.save(device);
    }

    @PutMapping("/devices/{id}")
    public void updateDevice(@PathVariable Integer id, @RequestBody DeviceApiModel deviceApiModel) {
        Device device = deviceRepository.getOne(id);
        Room room = roomRepository.getOne(deviceApiModel.getRoomId());

        device.setName(deviceApiModel.getName());
        device.setOn(deviceApiModel.getIsOn());
        device.setRoom(room);

        deviceRepository.save(device);
    }

    @DeleteMapping("/devices/{id}")
    public void deleteDevice(@PathVariable Integer id) {
        deviceRepository.deleteById(id);
    }

}
