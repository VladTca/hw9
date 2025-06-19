package ait.imaaga;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;


record ColorDtor2(String closest_palette_color, String closest_palette_color_parent, double percent) {}

record SubResultDtor2(List<ColorDtor2> background_colors, List<ColorDtor2> foreground_colors,
                     List<ColorDtor2> image_colors) {}

record ResultDtor2(SubResultDtor2 colors) {}

record ColorReasponseDtor2(ResultDtor2 result) {}

public class ImaagaColorR2Appl {
    public static void main(String[] args) {
        String imgUrl = "https://imagga.com/static/images/tagging/wind-farm-538576_640.jpg";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Basic YWNjXzM2MmVhNzVhMDRmZmRkYTo1MTBhM2EzNzI1MDM1ZmRjOTgzMDkwNmEyM2E2OGM4Yw==");
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("https://api.imagga.com/v2/colors")
                .queryParam("image_url", imgUrl);
        URI url = builder.build().toUri();
        RequestEntity<String> request = new RequestEntity<>(headers, HttpMethod.GET, url);
        ResponseEntity<ColorReasponseDtor2> response = restTemplate.exchange(request, ColorReasponseDtor2.class);

        System.out.println("Foreground Colors:");
        response.getBody().result().colors().foreground_colors().forEach(System.out::println);
        System.out.println("Background Colors:");
        response.getBody().result().colors().background_colors().forEach(System.out::println);
        System.out.println("Image Colors:");
        response.getBody().result().colors().image_colors().forEach(System.out::println);
    }
}
