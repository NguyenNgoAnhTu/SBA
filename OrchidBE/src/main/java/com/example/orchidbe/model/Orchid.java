package com.example.orchidbe.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "orchids")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Orchid {
    @Id
    private String orchidId;

    @Field("is_natural")
    private boolean isNatural;

    @Field("orchid_description")
    private String orchidDecription;

    @Field("orchid_name")
    private String orchidName;

    @Field("orchid_url")
    private String orchidUrl;

    @Field("price")
    private double price;
}