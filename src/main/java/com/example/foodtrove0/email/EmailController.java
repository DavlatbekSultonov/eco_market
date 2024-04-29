package com.example.foodtrove0.email;


import com.example.foodtrove0.email.dto.EmailRequestDto;
import com.example.foodtrove0.user.dto.ValidateEmailRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( EmailController.BATH_USER)
@RequiredArgsConstructor
public class EmailController {

    public static final String BATH_USER = "/email";

    private final EmailService emailService;

    @PostMapping("/auth/verification")
    public ResponseEntity<?> getVerification(@RequestBody ValidateEmailRequestDto validateEmailRequestDto){
        String verified = emailService.verifyEmail(validateEmailRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(verified);
    }


    @PostMapping("/auth/reTry")
    public ResponseEntity<?> reTryEmailVer(@RequestBody EmailRequestDto emailRequestDto){
        emailService.retry(emailRequestDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}