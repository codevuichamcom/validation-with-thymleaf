package com.example.demoerrorthymleaf;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
public class Person {
    Integer id;

    @NotEmpty(message = "The Full Name can't be null")
    @Size(min = 5, message = "The Full Name should have at least 5 characters")
    String fullName;

    @NotEmpty
    String email;

    @NotNull
    @Min(value = 18)
    Integer age;
}
