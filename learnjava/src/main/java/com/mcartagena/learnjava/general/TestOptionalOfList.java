package com.mcartagena.learnjava.general;

import com.mcartagena.model.Insurance;

import java.util.List;
import java.util.Optional;

public class TestOptionalOfList {
    public static void main(String[] args) {

//        List<Insurance> insurances1 = null;
//        List<Insurance> insurances2 = null;
//        List<Insurance> insurances1 = new ArrayList<>();
//        List<Insurance> insurances2 = new ArrayList<>();
//        List<Insurance> insurances1 = List.of(new Insurance(), new Insurance());
//        List<Insurance> insurances2 = List.of(new Insurance(), new Insurance());
        List<Insurance> insurances1 = List.of(Insurance.builder().name("Insurance 1").build(), new Insurance());
        List<Insurance> insurances2 = List.of(new Insurance(), new Insurance());

        String thisStatus;
        String otherStatus;


        if(Optional.ofNullable(insurances1).isPresent()){
            if(insurances1.size()>0) {
                thisStatus = Optional.ofNullable(insurances1.get(0).getName()).orElse("No existe")  ;
            } else {
                thisStatus = "No existe";
            }

        } else {
            thisStatus = "No existe";
        }

        if(Optional.ofNullable(insurances2).isPresent()){
            if(insurances2.size()>0) {
                otherStatus = Optional.ofNullable(insurances2.get(0).getName()).orElse("No existe");
            } else {
                otherStatus = "No existe";
            }
        } else {
            otherStatus = "No existe";
        }

        System.out.println("List 1: " + thisStatus);
        System.out.println("List 2: " + otherStatus);
    }
}
