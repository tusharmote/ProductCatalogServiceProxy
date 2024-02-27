package com.example.productcatalogserviceproxy.TableInheritanceExamples.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="st_instructor")
@DiscriminatorValue(value = "3")
public class Instructor extends User {
    private String company;
}
