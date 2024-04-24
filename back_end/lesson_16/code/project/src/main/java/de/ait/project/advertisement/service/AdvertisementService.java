package de.ait.project.advertisement.service;

import de.ait.project.advertisement.dto.AdvertisementResponseDto;
import de.ait.project.advertisement.dto.AdvertisementRequestDto;

import java.util.List;

public interface AdvertisementService {

    public List<AdvertisementResponseDto> getAll(String category);

    AdvertisementResponseDto getById(Long id);

    AdvertisementResponseDto addNew(AdvertisementRequestDto advertisementRequestDto);

    AdvertisementResponseDto deleteById(Long id);

    AdvertisementResponseDto updateById(Long id, AdvertisementRequestDto adv);
}
