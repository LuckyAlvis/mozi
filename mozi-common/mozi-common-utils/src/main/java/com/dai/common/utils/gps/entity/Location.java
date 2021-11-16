package com.dai.common.utils.gps.entity;

import lombok.Data;

@Data
public class Location {
    String locatioName;
    double longitude;
    double latitude;
    String type;
    Location children;
}
