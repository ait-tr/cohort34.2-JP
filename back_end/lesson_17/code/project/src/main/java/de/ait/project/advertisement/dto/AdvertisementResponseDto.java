package de.ait.project.advertisement.dto;

import de.ait.project.advertisement.model.Advertisement;
import de.ait.project.user.dto.UserResponseDto;
import de.ait.project.user.dto.UserShortResponseDto;
import lombok.Builder;
import lombok.Data;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder

public class AdvertisementResponseDto {
    private Long id;
    private String category;
    private String title;
    private String description;
    //private String authorName;
    private UserShortResponseDto author;

    public static AdvertisementResponseDto of(Advertisement advertisement){
        return AdvertisementResponseDto.builder()
                .id(advertisement.getId())
                .category(advertisement.getCategory())
                .title(advertisement.getTitle())
                .description(advertisement.getDescription())
                .author(UserShortResponseDto.from(advertisement.getAuthor()))
                .build();
    }

    public static List<AdvertisementResponseDto> of(List<Advertisement> advertisement) {
        if (advertisement==null)  {
                return Collections.EMPTY_LIST;
        }
        return advertisement
                .stream()
                .map(AdvertisementResponseDto::of)
                .collect(Collectors.toList());
    }

    }
