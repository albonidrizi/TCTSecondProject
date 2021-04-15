package com.tct.SecondProject.repository;

import com.tct.SecondProject.model.Device;
import com.tct.SecondProject.model.DeviceAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DeviceAttributeRepository extends JpaRepository<DeviceAttribute> {


    public DeviceAttribute findByDevice(Device device) {
        return null;
    }


}
