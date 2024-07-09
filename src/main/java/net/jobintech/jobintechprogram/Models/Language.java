package net.jobintech.jobintechprogram.Models;


import lombok.*;
import net.jobintech.jobintechprogram.Enums.LanguageLevel;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Language {

    private String name;
    private LanguageLevel languageLevel;

}
