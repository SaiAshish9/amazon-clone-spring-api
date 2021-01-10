package com.amazon.springapi.entity.home;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
@AllArgsConstructor
public class Deal {

    @Id
    private Integer id;

    private String image;

    private String description;

    private Double minPrice;

    private Double maxPrice;

    private Integer expiryDays;

    private Boolean best;

//    @CreatedDate
//    private LocalDateTime createdAt;
//
//    @LastModifiedDate
//    private LocalDateTime updatedAt;
//
//
//    public Deal(int l, String s, String s1, double v, double v1, int i, boolean b) {
//    }

}
