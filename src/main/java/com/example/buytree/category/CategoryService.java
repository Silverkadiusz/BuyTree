package com.example.buytree.category;

import com.example.buytree.offer.Offer;
import com.example.buytree.offer.OfferRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;
    private OfferRepository offerRepository;

    public CategoryService(CategoryRepository categoryRepository, OfferRepository offerRepository) {
        this.categoryRepository = categoryRepository;
        this.offerRepository = offerRepository;
    }

    public List<String> findAllNames() {
        return categoryRepository.findAll()
                .stream()
                .map(Category::getName)
                .collect(Collectors.toList());
    }

    public List<CategoryDto> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(category -> toDto(category))
                .collect(Collectors.toList());
    }

    private CategoryDto toDto(Category category) {
        CategoryDto dto = new CategoryDto();
        dto.setId(category.getId());
        dto.setDescription(category.getDescription());
        dto.setName(category.getName());

        return dto;

    }

    public void deleteCategory(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);

        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            Set<Offer> offers = category.getOffers();

            Category categoryDeleted = categoryRepository
                    .findById(1L)
                    .orElseThrow(() -> new RuntimeException("Kategoria nie istnieje"));

            List<Offer> updatedOffers = offers.stream()
                    .peek(offer -> offer.setCategory(categoryDeleted))
                    .collect(Collectors.toList());

            offerRepository.saveAll(updatedOffers);


            categoryRepository.deleteById(id);
        }

    }

    public CategoryDto insert(CategoryDto categoryDto) {
        Category category = new Category();
        category.setDescription(categoryDto.getDescription());
        category.setName(category.getName());
        categoryRepository.save(category);
        return toDto(category);

    }

}
