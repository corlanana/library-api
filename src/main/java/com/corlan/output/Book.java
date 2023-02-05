package com.corlan.output;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Book implements Serializable {
    public String kind;
    public String id;
    public String selfLink;
    public BookInfo volumeInfo;
}
