package com.samfresh09.resttemplatedemo.entities;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    private int id;
    private int userId;
    private String title;
    private String body;

}
