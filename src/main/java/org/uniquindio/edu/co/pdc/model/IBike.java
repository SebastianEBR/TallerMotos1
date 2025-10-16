package org.uniquindio.edu.co.pdc.model;

import java.time.Year;

public interface IBike {

    void run();
    void start();

    String getPlate();
    String getBrand();
    Year getModel();
}
