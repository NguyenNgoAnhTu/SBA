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
                        .orchidUrl("https://lanrungviet.com/wp-content/uploads/2021/06/lan-rung-phi-diep.jpg")
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
                        .build()
        ));
    }
}
