package com.example.foodtrove0.security.sms.eskiz;

//import org.example.eco_v2.security.sms.eskiz.dto.SendSmsRequestDto;
//import org.example.eco_v2.security.sms.eskiz.dto.TokenRefreshResponseDto;
import com.example.foodtrove0.security.sms.eskiz.dto.SendSmsRequestDto;
import com.example.foodtrove0.security.sms.eskiz.dto.TokenRefreshResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "eskizFeignClient", url = "https://notify.eskiz.uz/api")
public interface EskizFeignClient {
    @PatchMapping("/auth/refresh")
    TokenRefreshResponseDto refresh(@RequestHeader(HttpHeaders.AUTHORIZATION) String bearer);

    @PostMapping("/message/sms/send")
    String smsSend(@RequestHeader(HttpHeaders.AUTHORIZATION) String bearer,
                   @RequestBody SendSmsRequestDto sendSmsRequestDto);
}
