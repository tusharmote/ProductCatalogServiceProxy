package com.example.productcatalogserviceproxy.TableInheritanceExamples.MappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="msc_instructor")
public class Instructor extends User {
    private String company;
}
