package com.java.api.produtoapi.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    private Long id;
    private String title;
    private Double price;
    private Double discountPercentage;
    private Integer stock;
    private Double rating;
    private List<String> images;
    private String thumbnail;
    private String description;
    private String brand;
    private String category;
    private List<String> tags;

    public static Produto criarSerumPadrao() {
        return Produto.builder()
                .id(195L)
                .title("Hyaluronic Acid Serum")
                .price(19.0)
                .discountPercentage(13.31)
                .stock(110)
                .rating(4.83)
                .brand("L'Oreal Paris")
                .category("skincare")
                .description("L'Oréal Paris introduces Hyaluron Expert Serum")
                .thumbnail("https://i.dummyjson.com/data/products/16/thumbnail.jpg")
                .images(List.of("https://i.dummyjson.com/data/products/16/1.png",
                                "https://i.dummyjson.com/data/products/16/2.webp",
                                "https://i.dummyjson.com/data/products/16/3.jpg",
                                "https://i.dummyjson.com/data/products/16/4.jpg"))
                .build();
    }

    public static Produto criarCucumberPadrao() {
        return Produto.builder()
                .id(21L)
                .title("Cucumber")
                .price(1.49)
                .discountPercentage(0.16)
                .stock(84)
                .rating(4.07)
                .category("groceries")
                .description("Crisp and hydrating cucumbers, ideal for salads, snacks, or as a refreshing side.")
                .thumbnail("https://cdn.dummyjson.com/product-images/groceries/cucumber/thumbnail.webp")
                .images(List.of("https://cdn.dummyjson.com/product-images/groceries/cucumber/1.webp"))
                .tags(List.of("vegetables"))
                .build();
    }

    public static Produto criarMascaraLashPadrao() {
        return Produto.builder()
                .id(1L)
                .title("Essence Mascara Lash Princess")
                .price(9.99)
                .discountPercentage(10.48)
                .stock(99)
                .rating(2.56)
                .category("beauty")
                .description("The Essence Mascara Lash Princess is a popular mascara known for its volumizing and lengthening effects. Achieve dramatic lashes with this long-lasting and cruelty-free formula.")
                .thumbnail("https://cdn.dummyjson.com/product-images/beauty/essence-mascara-lash-princess/thumbnail.webp")
                .images(List.of("https://cdn.dummyjson.com/product-images/beauty/essence-mascara-lash-princess/1.webp"))
                .tags(List.of("beauty","mascara"))
                .brand("Essence")
                .build();
    }


}