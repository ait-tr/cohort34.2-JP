package de.ait.project.advertisement.service;

import de.ait.project.advertisement.dto.AdvertisementDto;
import de.ait.project.advertisement.dto.AdvertisementNewDto;

import java.util.List;

public interface AdvertisementService {

    public List<AdvertisementDto> getAll(String category);

    AdvertisementDto getById(Long id);

    AdvertisementDto addNew(AdvertisementNewDto advertisementNewDto);

    AdvertisementDto deleteById(Long id);

    AdvertisementDto updateById(Long id, AdvertisementNewDto adv);
}
