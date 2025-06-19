package ait.imaaga.dto;

import lombok.Getter;
import lombok.ToString;

import java.util.Map;


@Getter
@ToString
public class ColorDto {
    private String closest_palette_color;
    private String closest_palette_color_parent;
    private double percent;
}
