package de.ait.project.advertisement.service;

import de.ait.project.advertisement.dto.AdvertisementDto;
import de.ait.project.advertisement.dto.AdvertisementNewDto;
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
    public List<AdvertisementDto> getAll(String category) {
        if(category.isBlank()) {
            return AdvertisementDto.of(repository.findAll());
        } else {
            return AdvertisementDto.of(repository.findAllByCategory(category));
        }
    }

    @Override
    public AdvertisementDto getById(Long id) {
        return AdvertisementDto
                .of(repository
                        .findById(id)
                        .orElseThrow(()->new AdvertisementNotFoundException("Advertisement "+ id + " not found" )));
    }

    @Override
    public AdvertisementDto addNew(AdvertisementNewDto advertisementNewDto) {
        Advertisement advertisement = new Advertisement(null
                , advertisementNewDto.getCategory()
                , advertisementNewDto.getTitle()
                , advertisementNewDto.getDescription()
                , advertisementNewDto.getAuthorName());
        Advertisement savedAdv = repository.save(advertisement);
        return AdvertisementDto.of(advertisement);
    }

    @Override
    public AdvertisementDto deleteById(Long id) {
            AdvertisementDto deleted = getById(id);
            repository.deleteById(id);
            return deleted;
    }

    @Override
    public AdvertisementDto updateById(Long id, AdvertisementNewDto adv) {
        Advertisement advertisement = new Advertisement(id, adv.getCategory(), adv.getTitle(), adv.getDescription(), adv.getAuthorName());
        Advertisement updated = repository.save(advertisement);
        return AdvertisementDto.of(updated);
    }
}
