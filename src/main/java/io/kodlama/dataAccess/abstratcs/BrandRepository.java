package io.kodlama.dataAccess.abstratcs;

import org.springframework.data.jpa.repository.JpaRepository;

import io.kodlama.entities.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
	// Jpa exists gördüğü zaman parametreki name'i baz alarak ilgili veritabanına
	// gidip name kontrolü yapar ve true veya false döner
	// spring jpa keywords
	boolean existsByName(String name);
}
