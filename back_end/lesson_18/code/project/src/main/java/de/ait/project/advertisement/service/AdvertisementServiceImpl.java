package de.ait.project.advertisement.service;

import de.ait.project.advertisement.dto.AdvertisementResponseDto;
import de.ait.project.advertisement.dto.AdvertisementRequestDto;
import de.ait.project.advertisement.model.Advertisement;
import de.ait.project.advertisement.repository.AdvertisementRepository;
import de.ait.project.exceptions.AdvertisementNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdvertisementServiceImpl implements AdvertisementService {

    private final AdvertisementRepository repository;

    @Override
    public List<AdvertisementResponseDto> getAll(String category) {
        if(category.isBlank()) {
            return AdvertisementResponseDto.of(repository.findAll());
        } else {
            return AdvertisementResponseDto.of(repository.findAllByCategory(category));
        }
    }

    @Override
    public AdvertisementResponseDto getById(Long id) {
        return AdvertisementResponseDto
                .of(repository
                        .findById(id)
                        .orElseThrow(()->new AdvertisementNotFoundException("Advertisement "+ id + " not found" )));
    }

    @Override
    public AdvertisementResponseDto addNew(AdvertisementRequestDto advertisementRequestDto) {
        Advertisement advertisement = new Advertisement(null
                , advertisementRequestDto.getCategory()
                , advertisementRequestDto.getTitle()
                , advertisementRequestDto.getDescription()
                //, advertisementRequestDto.getAuthorName()
                , null);     // TODO add author
        Advertisement savedAdv = repository.save(advertisement);
        return AdvertisementResponseDto.of(advertisement);
    }

    @Override
    public AdvertisementResponseDto deleteById(Long id) {
            AdvertisementResponseDto deleted = getById(id);
            repository.deleteById(id);
            return deleted;
    }

    @Override
    public AdvertisementResponseDto updateById(Long id, AdvertisementRequestDto adv) {
        Advertisement advertisement = new Advertisement(id, adv.getCategory(), adv.getTitle(), adv.getDescription(), null); /// TODO
        Advertisement updated = repository.save(advertisement);
        return AdvertisementResponseDto.of(updated);
    }
}
