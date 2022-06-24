package com.example.validation.controller;

import com.example.validation.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ApiController {

    @PostMapping("/user")
    public ResponseEntity user(@Valid @RequestBody User user, BindingResult bindingResult) { // @Valid annotation 이 있어야 검증을 함, Validation에 대한 결과가 BindingResult에 값을 넣어줌
        System.out.println("USER: " + user);
        if(bindingResult.hasErrors()){
            StringBuilder sb = new StringBuilder();
            bindingResult.getAllErrors().forEach(objectError -> {
                FieldError field = (FieldError) objectError;
                String message = objectError.getDefaultMessage();

                System.out.println("field" + field.getField());
                System.out.println(message);

                sb.append("field : " + field.getField() + "\n");
                sb.append("message : " + message);
            });

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());

        }
//        if (user.getAge() >= 90) { // 확인할 내용이 많아지면 코드가 길어지고 복잡해짐
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
//        }
        return ResponseEntity.ok(user);
    }
}
