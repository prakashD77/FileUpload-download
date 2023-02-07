package com.mss.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mss.entity.ImageData;

public interface Storagerepository  extends JpaRepository<ImageData,Long>{
	
Optional<ImageData>findByName(String filename);
	
}

