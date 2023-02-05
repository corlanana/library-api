package com.corlan.controller;

import com.corlan.exception.BookExceptionDto;
import com.corlan.output.BookOutDto;
import com.corlan.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Operation(summary = "Get a book by its title")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the book",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BookOutDto.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BookExceptionDto.class))})
    })
    @GetMapping(path = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public BookOutDto search(@RequestParam(value = "bookName") String bookName,
                              @RequestParam(value = "maxResults", required = false) Long maxResults,
                              @RequestParam(value = "langRestrict", required = false) String langRestrict,
                              @RequestParam(value = "orderBy", required = false) String orderBy
                              ){
        return bookService.searchBook(bookName, maxResults, langRestrict, orderBy);
    }

}
