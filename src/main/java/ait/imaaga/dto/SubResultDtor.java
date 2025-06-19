package ait.imaaga.dto;

import java.util.List;

public record SubResultDtor(List<ColorDtor> background_colors, List<ColorDtor> foreground_colors, List<ColorDtor> image_colors) {
}
