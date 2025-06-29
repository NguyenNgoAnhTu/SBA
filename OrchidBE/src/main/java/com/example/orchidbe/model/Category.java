package com.example.orchidbe.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "categories")
public class Category {
    @Id
    private String categoryId;

    @Field("category_name")
    @Indexed(unique = true)
    private String categoryName;
}