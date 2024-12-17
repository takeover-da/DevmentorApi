package com.example.demo.roadmap.repository;

import com.example.demo.roadmap.entity.Roadmap;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoadmapRepository extends JpaRepository<Roadmap, Integer> {

}
