package com.hexaware.movieticketbooking.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.hexaware.movieticketbooking.entity.Seating;

public interface SeatingRepository extends JpaRepository<Seating,Integer> {
    List<Seating> findByBookedFalse();

}