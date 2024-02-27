package com.example.productcatalogserviceproxy.TableInheritanceExamples.JoinedClass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="jc_ta")
@PrimaryKeyJoinColumn(name="user_id")
public class Ta extends User {
    private int ratings;
}
