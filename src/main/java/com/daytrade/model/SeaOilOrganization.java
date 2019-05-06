package com.daytrade.model;

public class SeaOilOrganization implements OilOrganization {
    Especiality especiality;
    @Override
    public void extractOil() {
        System.out.println("Extracting from Sea");
    }
}

