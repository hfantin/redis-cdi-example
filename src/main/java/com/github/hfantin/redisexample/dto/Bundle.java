package com.github.hfantin.redisexample.dto;

public class Bundle {


    private String name;
    private String version;
    private String location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Bundle{" +
                "name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
