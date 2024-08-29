package com.getcarro.interview.external;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "getcarro", url = "https://mognet.vyrl.co")
public interface GetCarroClient {
}