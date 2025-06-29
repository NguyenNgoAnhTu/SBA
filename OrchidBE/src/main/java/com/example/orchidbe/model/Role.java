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
@Document(collection = "roles")
public class Role {
    @Id
    private String roleId;

    @Field("role_name")
    @Indexed(unique = true)
    private String roleName;
}