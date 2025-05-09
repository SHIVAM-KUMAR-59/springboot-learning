package com.shivam._72.Quiz_Service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizDto {

    private String category;
    private Integer num;
    private String title;

}
