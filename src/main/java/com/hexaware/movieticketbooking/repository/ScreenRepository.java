package com.hexaware.movieticketbooking.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.hexaware.movieticketbooking.entity.Screen;

public interface ScreenRepository extends JpaRepository<Screen, Integer> {
    List<Screen> findByTheatreId(int theatreId);

    // Add custom query methods if needed
}
