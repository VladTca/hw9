package ait.imaaga.dto;


import lombok.Getter;

import java.util.List;

@Getter
public class SubResultDto {
    private List<ColorDto> background_colors;
    private List<ColorDto> foreground_colors;
    private List<ColorDto> image_colors;
}
