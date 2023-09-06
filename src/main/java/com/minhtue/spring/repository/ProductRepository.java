package com.minhtue.spring.repository;

import com.minhtue.spring.models.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> list = new ArrayList<Product>(Arrays.asList(
            new Product(1, "IPhone 14", 1500000),
            new Product(2, "IPhone plus", 1610000),
            new Product(3, "oppo", 2000000),
            new Product(4, "samsung galaxy", 1900000)
    ));

    public List<Product> getAll() {
        return list;
    }

    public Product getById(int id) {
        Product product = new Product();
        for (Product p : list) {
            if (p.getId() == id) {
                product = p;
                break;
            }
        }
        return product;
    }

    public void update(Product input) {
        Product product = getById(input.getId());
        int index = list.indexOf(product);
        list.set(index, input);
    }

    public void insert(Product input) {
        list.add(input);
    }

    public void delete(int id) {
        Product product = getById(id);
        list.remove(product);
    }
}
