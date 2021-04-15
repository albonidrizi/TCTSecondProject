package com.tct.SecondProject.model;

public class DiviceApiModel {


    private Integer id;
    private  String name;
    private  Boolean isOn;
    private Integer roomId;

    public void DeviceApiModel(){ }

    public DiviceApiModel(Device divice){
        this.id = divice.getId();
        this.name = divice.getName();
        this.isOn = divice.getIsOn();
        this.roomId = divice.getRoomId();
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

    public Boolean getOn() {
        return isOn;
    }
    public void setOn(Boolean on) {
        isOn = on;
    }

    public Integer getRoomId() {
        return roomId;
    }
    public void setRoomId(Integer roomId) {
        this.roomId = roomId; }


}
