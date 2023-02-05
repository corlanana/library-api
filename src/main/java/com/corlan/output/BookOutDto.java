package com.corlan.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class BookOutDto implements Serializable {
    public String kind;
    public Integer totalItems;
    public List<Book> items;
}
