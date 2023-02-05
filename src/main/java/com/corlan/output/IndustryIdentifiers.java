package com.corlan.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class IndustryIdentifiers implements Serializable {
    public String type;
    public String identifier;
}
