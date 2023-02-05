package com.corlan.service;

import com.corlan.exception.BookException;
import com.corlan.output.BookOutDto;
import com.corlan.util.BookOrderType;
import com.corlan.util.Consts;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class BookService {
    private final RestTemplate restTemplate;


    public BookService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public BookOutDto searchBook(String bookName, Long maxResults, String langRestrict, String orderBy){
        String path = buildPath(Consts.BASE_PATH, bookName, maxResults, langRestrict, orderBy);
        ResponseEntity<BookOutDto> responseEntity = restTemplate.getForEntity(path , BookOutDto.class);
        BookOutDto response = responseEntity.getBody();
        return  response;
    }

    private String buildPath(String basePath, String bookName, Long maxResults, String langRestrict, String orderBy){
        return validateMandatoryBookTitle(basePath,bookName) +
                buildOptionalParameters(maxResults, langRestrict, orderBy);
    }
    private String validateMandatoryBookTitle(String path, String bookName){

        if(null != bookName && !bookName.isEmpty())
            path += Consts.QUESTION_MARK + Consts.TITLE_PARAM + Consts.EQUALS_SIGN + bookName;
        else
            throw new BookException("The bookName must not be empty, please provide a search title!");
        return path;
    }
    private String buildOptionalParameters(Long maxResults, String langRestrict, String orderBy){
        String path = Consts.EMPTY_STRING;
        Map<String,String> searchParameters = new HashMap<>();

        if (null != maxResults)
           searchParameters.put(Consts.MAX_RESULTS, String.valueOf(maxResults));

       if(null != langRestrict && !langRestrict.isEmpty()) {
           if (langRestrict.length() == 1 || langRestrict.length() > 2) {
               throw new BookException("The langRestrict parameter must be a two letter abbreviation of a language!");
           } else {
               searchParameters.put(Consts.LANG_RESTRICT, langRestrict);
           }
       }

       if (null != orderBy && !orderBy.isEmpty()) {
           if (BookOrderType.NEWEST.name().equalsIgnoreCase(orderBy)) {
               searchParameters.put(Consts.ORDER_BY, orderBy);
           } else if (BookOrderType.RELEVANCE.name().equalsIgnoreCase(orderBy)) {
               searchParameters.put(Consts.ORDER_BY, orderBy);
           } else {
               throw new BookException("The orderBy parameter must be either NEWEST or RELEVANCE!");
           }
       }

       for (String param : searchParameters.keySet()){
           path += Consts.DOUBLE_AND + param + Consts.EQUALS_SIGN + searchParameters.get(param);
       }

        return path;
    }
}
