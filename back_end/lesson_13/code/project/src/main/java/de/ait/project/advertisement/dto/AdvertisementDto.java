package de.ait.project.advertisement.dto;

import de.ait.project.advertisement.model.Advertisement;
import jdk.jfr.DataAmount;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder

public class AdvertisementDto {
    private Long id;
    private String category;
    private String title;
    private String description;
    private String authorName;

    public static AdvertisementDto of(Advertisement advertisement){
        return AdvertisementDto.builder()
                .id(advertisement.getId())
                .category(advertisement.getCategory())
                .title(advertisement.getTitle())
                .description(advertisement.getDescription())
                .authorName(advertisement.getAuthorName())
                .build();
    }

    public static List<AdvertisementDto> of(List<Advertisement> advertisement) {
        return advertisement
                .stream()
                .map(AdvertisementDto::of)
                .collect(Collectors.toList());
    }

    }
