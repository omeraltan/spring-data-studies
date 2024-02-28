package com.spring.data.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RatingAttributeConverter implements AttributeConverter<Rating, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Rating attribute) {
        if (attribute == null) return null;
        return attribute.getValue();
    }

    @Override
    public Rating convertToEntityAttribute(Integer dbData) {
        if (dbData == null) return null;
        if (dbData == 100) return Rating.STANDART;
        else return Rating.PREMIUM;
    }
}
