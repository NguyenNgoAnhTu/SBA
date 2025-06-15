package com.example.orchidbe.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name="orchids")
public class Orchid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orchidId;
    @Column(name="is_natural", nullable = false)
    private boolean isNatural;
    @Column(name="orchid_decription", nullable = false)
    private String orchidDecription;
    @Column(name="orchid_name", nullable = false)
    private String orchidName;
    @Column(name="orchid_url", nullable = false)
    private String orchidUrl;
    @Column(name="price", nullable = false)
    private double price;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
