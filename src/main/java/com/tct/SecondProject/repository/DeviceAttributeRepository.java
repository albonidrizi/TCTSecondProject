package com.tct.SecondProject.repository;

import com.tct.SecondProject.model.Device;
import com.tct.SecondProject.model.DeviceAttribute;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceAttributeRepository extends JpaRepository<DeviceAttribute, Integer> {

    List<DeviceAttribute> findByDevice(Device device, Pageable pageable);

    int countByDevice(Device device);

}
