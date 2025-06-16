package com.tracker.task.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="jpa_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    //@ManyToMany(mappedBy = "products")// Now the relationship is owned/handled by the `products` field in the Category class
    //now the relationship is owned/handled by products field of Category class
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="product_categories",
            joinColumns = @JoinColumn(name="p_id"),
            inverseJoinColumns =  @JoinColumn(name="c_id")

    )
    private List<Category> categories = new ArrayList<>();

    public void addCategory(Category category){
        this.categories.add(category);
        category.getProducts().add(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
