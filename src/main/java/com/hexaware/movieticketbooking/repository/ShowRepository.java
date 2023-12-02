package com.hexaware.movieticketbooking.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.hexaware.movieticketbooking.entity.Show;

public interface ShowRepository extends JpaRepository<Show, Integer> {
    List<Show> findByTheatreIdAndScreenId(int theatreId, int screenId);
    List<Show> findByTheatreId(int theatreId);
}