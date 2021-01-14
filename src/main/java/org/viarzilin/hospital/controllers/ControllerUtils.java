package org.viarzilin.hospital.controllers;

import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.viarzilin.hospital.domain.Patient;

import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ControllerUtils {
    public static Integer[] pagerUtil(Page<Patient> page) {
        Integer totalPages = page.getTotalPages();
        Integer pageNumber = page.getNumber() + 1;

        Stream<Integer> head = (pageNumber > 4) ? Stream.of(1, -1) : Stream.of(1, 2, 3);
        Stream<Integer> tail = (pageNumber < totalPages - 3) ? Stream.of(-1, totalPages) : Stream.of(totalPages - 2, totalPages - 1, totalPages);
        Stream<Integer> bodyBefore = (pageNumber > 4 && pageNumber < totalPages - 1) ? Stream.of(pageNumber - 2, pageNumber - 1) : Stream.of();
        Stream<Integer>bodyAfter = (pageNumber > 2 && pageNumber < totalPages - 3) ? Stream.of(pageNumber + 1, pageNumber + 2) : Stream.of();
        Stream<Integer> centralSection = (pageNumber > 3 && pageNumber < totalPages - 2) ? Stream.of(pageNumber) : Stream.of();
        Stream<Integer> body = Stream.of(head, bodyBefore, centralSection, bodyAfter, tail)
                .reduce(Stream::concat)
                .orElseGet(Stream::empty);

         return body.toArray(Integer[]::new);
    }



    static Map<String, String> getErrors(BindingResult bindingResult){
        Collector<FieldError, ?, Map<String, String>> collector = Collectors.toMap(
                fieldError -> fieldError.getField() + "Error",
                FieldError::getDefaultMessage
        );

    return bindingResult.getFieldErrors().stream().collect(collector);
    }


}
