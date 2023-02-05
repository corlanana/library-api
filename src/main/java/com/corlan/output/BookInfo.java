package com.corlan.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class BookInfo implements Serializable {
    public String title;
    public List<String> authors;
    public String publishedDate;
    public List<IndustryIdentifiers> industryIdentifiers;
    public String pageCount;
    public String language;
}


