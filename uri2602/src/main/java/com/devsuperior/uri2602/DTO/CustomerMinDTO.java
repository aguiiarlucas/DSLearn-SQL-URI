package com.devsuperior.uri2602.DTO;

import com.devsuperior.uri2602.projections.CustomerMinProjection;

public class CustomerMinDTO {

    String name;


    public CustomerMinDTO() {
    }

    public CustomerMinDTO(String name) {
        this.name = name;
    }

    public CustomerMinDTO(CustomerMinProjection projection){
        name = projection.getName();
    }

    @Override
    public String toString() {
        return "CustomerMinDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
