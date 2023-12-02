package com.hexaware.movieticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.movieticketbooking.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

	Movie findByMovieName(String movieName);

    // You can add custom query methods here if needed
}
