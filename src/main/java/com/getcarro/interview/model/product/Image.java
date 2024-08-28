package com.getcarro.interview.model.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    private String altText;
    private String id;
    private String mediaURL;
    private Integer position;
}
