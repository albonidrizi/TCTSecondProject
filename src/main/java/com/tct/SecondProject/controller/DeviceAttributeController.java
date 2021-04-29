package com.tct.SecondProject.controller;

import com.tct.SecondProject.model.AttributeApiModel;
import com.tct.SecondProject.model.Device;
import com.tct.SecondProject.model.DeviceAttribute;
import com.tct.SecondProject.model.FindAll;
import com.tct.SecondProject.repository.DeviceAttributeRepository;
import com.tct.SecondProject.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
public class DeviceAttributeController {

    @Autowired
    private DeviceAttributeRepository deviceAttributeRepository;
    @Autowired
    private DeviceRepository deviceRepository;

    @GetMapping("/devices/{deviceId}/attributes")
    public FindAll<AttributeApiModel> getDeviceAttributes(
            @PathVariable Integer deviceId ,
            @RequestParam Integer pageNumber,
            @RequestParam Integer pageSize ) {

        Pageable pageable = PageRequest.of(pageNumber , pageSize);

        Optional<Device> optional = deviceRepository.findById(deviceId);
        Device device = optional.get();
        List<DeviceAttribute> attributes = deviceAttributeRepository.findByDevice(device, pageable);
        List<AttributeApiModel> models = attributes.stream()
                .map(AttributeApiModel::new)
                .collect(Collectors.toList());

        FindAll<AttributeApiModel> all = new FindAll<>();
        all.setItems(models);
        all.setPage(pageNumber);
        all.setTotal(deviceAttributeRepository.countByDevice(device));

        return all;
    }

    @PostMapping("/devices/{deviceId}/attributes")
    public void createAttribute(@PathVariable Integer deviceId, @RequestBody AttributeApiModel model) {
        Device device = deviceRepository.getOne(deviceId);

        DeviceAttribute deviceAttribute = new DeviceAttribute();
        deviceAttribute.setName(model.getName());
        deviceAttribute.setCurrentValue(model.getCurrentValue());
        deviceAttribute.setMinValue(model.getMinValue());
        deviceAttribute.setMaxValue(model.getMaxValue());
        deviceAttribute.setDevice(device);

        deviceAttributeRepository.save(deviceAttribute);
    }

    @PutMapping("/devices/{deviceId}/attributes/{attributeId}")
    public void updateAttribute(@PathVariable Integer deviceId,
                                @PathVariable Integer attributeId,
                                @RequestBody AttributeApiModel apiModel) {
        DeviceAttribute attribute = deviceAttributeRepository.getOne(attributeId);
        attribute.setName(apiModel.getName());
        attribute.setCurrentValue(apiModel.getCurrentValue());
        attribute.setMinValue(apiModel.getMinValue());
        attribute.setMaxValue(apiModel.getMaxValue());

        deviceAttributeRepository.save(attribute);
    }

    @DeleteMapping("/devices/{deviceId}/attributes/{attributeId}")
    public void deleteAttribute(@PathVariable Integer attributeId) {
        deviceAttributeRepository.deleteById(attributeId);
    }

}
