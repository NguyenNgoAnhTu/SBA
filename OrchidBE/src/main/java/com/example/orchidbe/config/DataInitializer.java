package com.example.orchidbe.config;

import com.example.orchidbe.model.Account;
import com.example.orchidbe.model.Category;
import com.example.orchidbe.model.Orchid;
import com.example.orchidbe.model.Role;
import com.example.orchidbe.repository.AccountRepository;
import com.example.orchidbe.repository.CategoryRepository;
import com.example.orchidbe.repository.OrchidRepository;
import com.example.orchidbe.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final CategoryRepository categoryRepo;
    private final OrchidRepository orchidRepo;
    private final RoleRepository roleRepo;
    private final AccountRepository accountRepo;

    @Override
    public void run(String... args) {
        if(categoryRepo.count() > 0 || orchidRepo.count() > 0 || roleRepo.count() > 0 || accountRepo.count() > 0) {
            return; // Data already initialized
        }

        Role adminRole = roleRepo.save(new Role(null, "ROLE_ADMIN"));
        Role userRole = roleRepo.save(new Role(null, "ROLE_USER"));

        // Create categories
        Category phalaenopsis = categoryRepo.save(new Category(null, "Phalaenopsis Orchid"));
        Category wild = categoryRepo.save(new Category(null, "Wild Orchid"));
        Category vanda = categoryRepo.save(new Category(null, "Vanda Orchid"));
        Category cattleya = categoryRepo.save(new Category(null, "Cattleya Orchid"));
        Category dendrobium = categoryRepo.save(new Category(null, "Dendrobium Orchid"));
        Category oncidium = categoryRepo.save(new Category(null, "Oncidium Orchid"));
        Category miltonia = categoryRepo.save(new Category(null, "Miltonia Orchid"));

        // Create orchids
        orchidRepo.saveAll(List.of(
                Orchid.builder()
                        .orchidName("Natural Orange Phalaenopsis")
                        .orchidDecription("A natural orange Phalaenopsis with smooth petals and light fragrance.")
                        .orchidUrl("/images/Phalaenopsis.jpg")
                        .isNatural(true)
                        .price(250000)
                        .category(phalaenopsis)
                        .build(),

                Orchid.builder()
                        .orchidName("Hybrid White Phalaenopsis")
                        .orchidDecription("A hybrid white Phalaenopsis, ideal for home and office decor.")
                        .orchidUrl("/images/flowerama.jpg")
                        .isNatural(false)
                        .price(180000)
                        .category(phalaenopsis)
                        .build(),

                Orchid.builder()
                        .orchidName("Wild Phi Diep Orchid")
                        .orchidDecription("Original wild orchid collected from mountain forests.")
                        .orchidUrl("/images/phidiep.jpg")
                        .isNatural(true)
                        .price(350000)
                        .category(wild)
                        .build(),

                Orchid.builder()
                        .orchidName("Hybrid Purple Vanda")
                        .orchidDecription("A hybrid purple Vanda, easy to grow and bloom.")
                        .orchidUrl("/images/wild.jpg")
                        .isNatural(false)
                        .price(220000)
                        .category(vanda)
                        .build(),

                Orchid.builder()
                        .orchidName("Natural Cattleya")
                        .orchidDecription("Natural Cattleya with strong fragrance and vivid pink color.")
                        .orchidUrl("/images/Cattleya.jpg")
                        .isNatural(true)
                        .price(400000)
                        .category(cattleya)
                        .build(),
                Orchid.builder()
                        .orchidName("Golden Dendrobium")
                        .orchidDecription("Bright golden flowers, often used in ceremonies.")
                        .orchidUrl("/images/dendrobium.jpg")
                        .isNatural(true)
                        .price(200000)
                        .category(dendrobium)
                        .build(),

                Orchid.builder()
                        .orchidName("Fragrant Oncidium")
                        .orchidDecription("Known as 'Dancing Lady' orchid with sweet fragrance.")
                        .orchidUrl("/images/oncidium.jpg")
                        .isNatural(false)
                        .price(270000)
                        .category(oncidium)
                        .build(),

                Orchid.builder()
                        .orchidName("Miltonia Sunset")
                        .orchidDecription("Hybrid with beautiful sunset colors, easy to grow.")
                        .orchidUrl("/images/miltonia.jpg")
                        .isNatural(false)
                        .price(300000)
                        .category(miltonia)
                        .build(),

//                Orchid.builder()
//                        .orchidName("Natural Mountain Vanda")
//                        .orchidDecription("Collected from highland forests, rare Vanda type.")
//                        .orchidUrl("https://example.com/images/natural-vanda.jpg")
//                        .isNatural(true)
//                        .price(500000)
//                        .category(vanda)
//                        .build(),

                Orchid.builder()
                        .orchidName("White Snow Cattleya")
                        .orchidDecription("Pure white petals, symbolic for purity and grace.")
                        .orchidUrl("/images/white-cattleya.jpg")
                        .isNatural(true)
                        .price(450000)
                        .category(cattleya)
                        .build(),

                Orchid.builder()
                        .orchidName("Phalaenopsis Pink Beauty")
                        .orchidDecription("Orchid with soft pink petals, highly popular.")
                        .orchidUrl("/images/pink-phalaenopsis.jpg")
                        .isNatural(false)
                        .price(230000)
                        .category(phalaenopsis)
                        .build(),

                Orchid.builder()
                        .orchidName("Wild Jungle Orchid")
                        .orchidDecription("Unmodified, grows in natural jungle conditions.")
                        .orchidUrl("/images/wild-jungle.jpg")
                        .isNatural(true)
                        .price(480000)
                        .category(wild)
                        .build()

        ));

        // Create accounts
        accountRepo.saveAll(List.of(
                Account.builder()
                        .accountName("admin")
                        .email("admin@gmail.com")
                        .password("123")
                        .role(adminRole)
                        .build(),

                Account.builder()
                        .accountName("john")
                        .email("user@gmail.com")
                        .password("123")
                        .role(userRole)
                        .build(),
                Account.builder()
                        .accountName("alice")
                        .email("alice@example.com")
                        .password("123")
                        .role(userRole)
                        .build(),

                Account.builder()
                        .accountName("bob")
                        .email("bob@example.com")
                        .password("123")
                        .role(userRole)
                        .build()
        ));
    }
}
