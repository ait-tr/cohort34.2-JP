package de.ait.project.advertisement.repository;

import de.ait.project.advertisement.model.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdvertisementRepository extends JpaRepository<Advertisement,Long> {
    List<Advertisement> findAllByCategory(String category);
    List<Advertisement> findAllByCategoryAndAuthorName(String category, String autorName);
}
