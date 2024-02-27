package com.example.productcatalogserviceproxy.TableInheritanceExamples.MappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="msc_ta")
public class Ta extends User {
    private int ratings;
}
