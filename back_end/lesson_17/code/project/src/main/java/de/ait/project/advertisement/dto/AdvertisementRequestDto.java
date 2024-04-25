package de.ait.project.advertisement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdvertisementRequestDto {
    private String category;
    private String title;
    private String description;

}
