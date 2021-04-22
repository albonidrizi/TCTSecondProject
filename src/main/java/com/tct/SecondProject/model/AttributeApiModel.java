package com.tct.SecondProject.model;

public class AttributeApiModel {
    private Integer id;
    private String name;
    private Integer minValue;
    private Integer currentValue;
    private Integer maxValue;
    private Integer deviceId;

    public AttributeApiModel() {}

    public AttributeApiModel(DeviceAttribute attribute) {
        this.id = attribute.getId();
        this.name = attribute.getName();
        this.minValue = attribute.getMinValue();
        this.currentValue = attribute.getCurrentValue();
        this.maxValue = attribute.getMaxValue();
        this.deviceId = attribute.getDevice().getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMinValue() {
        return minValue;
    }

    public void setMinValue(Integer minValue) {
        this.minValue = minValue;
    }

    public Integer getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Integer currentValue) {
        this.currentValue = currentValue;
    }

    public Integer getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Integer maxValue) {
        this.maxValue = maxValue;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }
}
