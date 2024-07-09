package net.jobintech.jobintechprogram.Models;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Address {

    private String country;
    private String region;
    private String city;
    private String street;
    private String zipCode;

}
