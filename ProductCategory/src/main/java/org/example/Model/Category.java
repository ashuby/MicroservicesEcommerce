package org.example.Model;

import javax.persistence.*;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue
    @Column(name = "category")
    private int categoryId;

    @Column(name = "categoryName")
    private String categoryName;

    @Column(name = "categoryDes")
    private String categoryDescription;
}
