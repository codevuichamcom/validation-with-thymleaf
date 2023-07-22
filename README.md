# Hướng dẫn show error messgae với thymleaf + validation

## B1: Thêm thư viện validation vào dự án
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```
## B2: Để kiểm validate 1 object chúng ta sử dụng @Valid ở trước đối tượng
```java
 @PostMapping("/add")
    public String addPerson(@Valid Person person, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-person";
        }
        personService.save(person);
        return "redirect:/";
    }
```
- nếu có 1 field không hợp lệ (result.hasError) -> show error messge
```html
<div class="form-group">
    <label for="fullName">Name</label>
    <input class="form-control" type="text" th:field="*{fullName}" id="fullName" placeholder="Full Name">
    <div class="alert alert-warning" th:if="${#fields.hasErrors('fullName')}" th:errors="*{fullName}"></div>
</div>
```
## B3: Định nghĩa các validation tương ứng 
```java
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
```

#Happy coding 😎
