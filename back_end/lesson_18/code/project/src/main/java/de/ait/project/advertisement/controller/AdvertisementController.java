package de.ait.project.advertisement.controller;

import de.ait.project.advertisement.dto.AdvertisementResponseDto;
import de.ait.project.advertisement.dto.AdvertisementRequestDto;
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
    public List<AdvertisementResponseDto> getAll(@RequestParam(required = false, defaultValue = "")  String category){
        return service.getAll(category);
    }

    @GetMapping("/{id}")
    public AdvertisementResponseDto getBiId(@PathVariable Long id){
        return service.getById(id);
    }

    @PostMapping
    public AdvertisementResponseDto addNewAdvertisement(@RequestBody AdvertisementRequestDto advertisementRequestDto){
        return service.addNew(advertisementRequestDto);
    }


    @DeleteMapping("/{id}")
    public AdvertisementResponseDto deleteById(@PathVariable Long id){
        return service.deleteById(id);
    }

    @PutMapping("/{id}")
    public AdvertisementResponseDto deleteById(@PathVariable Long id, @RequestBody AdvertisementRequestDto adv){
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