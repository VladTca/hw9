package ait.imaaga;

import ait.imaaga.dto.ColorReasponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class ImaagaColorAppl {
    public static void main(String[] args) {
        String imgUrl = "https://imagga.com/static/images/tagging/wind-farm-538576_640.jpg";
        String lang = "ru";
        int threshold = 30;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Basic YWNjXzM2MmVhNzVhMDRmZmRkYTo1MTBhM2EzNzI1MDM1ZmRjOTgzMDkwNmEyM2E2OGM4Yw==");
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("https://api.imagga.com/v2/colors")
                .queryParam("image_url", imgUrl);
        URI url = builder.build().toUri();
        RequestEntity<String> request = new RequestEntity<>(headers, HttpMethod.GET, url);
        ResponseEntity<ColorReasponseDto> response = restTemplate.exchange(request, ColorReasponseDto.class);
        System.out.println("Foreground Colors:");
        response.getBody().getResult().getColors().getForeground_colors().forEach(System.out::println);
        System.out.println("Background Colors:");
        response.getBody().getResult().getColors().getBackground_colors().forEach(System.out::println);
        System.out.println("Image Colors:");
        response.getBody().getResult().getColors().getImage_colors().forEach(System.out::println);
    }
}
