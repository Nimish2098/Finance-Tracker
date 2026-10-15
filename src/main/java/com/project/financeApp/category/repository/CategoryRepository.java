package com.project.financeApp.category.repository;



import com.project.financeApp.category.entity.Category;
import com.project.financeApp.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {

    List<Category> findByUser(User user);

    Optional<Category> findByIdAndUser(UUID id, User user);
    Optional<Category> findByNameAndUser(String name, User user);

}
