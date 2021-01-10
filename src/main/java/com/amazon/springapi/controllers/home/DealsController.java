package com.amazon.springapi.controllers.home;

import com.amazon.springapi.repository.home.DealsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public/home/")
public class DealsController {

    @Autowired
    private DealsRepository dealsRepository;

    @GetMapping("deals")
    public ResponseEntity<?> getDeals(){
        return ResponseEntity.ok(dealsRepository.findAll());
    }

    @GetMapping("best-deal")
    public ResponseEntity<?> getBestDeal(){
        return ResponseEntity.ok(dealsRepository.findByBestIsTrue());
    }

}
