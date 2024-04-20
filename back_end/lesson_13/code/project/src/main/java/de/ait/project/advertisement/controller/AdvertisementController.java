package de.ait.project.advertisement.controller;

import de.ait.project.advertisement.dto.AdvertisementDto;
import de.ait.project.advertisement.dto.AdvertisementNewDto;
import de.ait.project.advertisement.service.AdvertisementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/advertisements")
@RequiredArgsConstructor
public class AdvertisementController {
    private final AdvertisementService service;

   // /api/advertisements?category=sport   (!!)
    @GetMapping
    public List<AdvertisementDto> getAll(@RequestParam(required = false, defaultValue = "")  String category){
        return service.getAll(category);
    }

    @GetMapping("/{id}")
    public AdvertisementDto getBiId(@PathVariable Long id){
        return service.getById(id);
    }

    @PostMapping
    public AdvertisementDto addNewAdvertisement(@RequestBody AdvertisementNewDto advertisementNewDto){
        return service.addNew(advertisementNewDto);
    }


    @DeleteMapping("/{id}")
    public AdvertisementDto deleteById(@PathVariable Long id){
        return service.deleteById(id);
    }

    @PutMapping("/{id}")
    public AdvertisementDto deleteById(@PathVariable Long id, @RequestBody AdvertisementNewDto adv){
        return service.updateById(id, adv);
    }

}

/*
 * добавить объявление,
 * найти объявление по id
 * вывести все объявления в заданной категории
 * изменить объявление
 * удалить объявление

/api/advertisements/categories/{category}
/api/advertisements?category=sport   (!!)

/api/advertisements/{category} /// !!!Error
 */