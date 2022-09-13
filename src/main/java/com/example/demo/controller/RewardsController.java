package com.example.demo.controller;

import com.example.demo.entity.Rewards;
import com.example.demo.service.RewardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rewards")
public class RewardsController {

    @Autowired
    RewardsService rewardService;

    @RequestMapping(value = "/retrieve-customer-rewards-total", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<Rewards> retrieveTotalRewards(@RequestParam(required = true) String email) {

        Rewards rewards = rewardService.calculateTotalRewards(email);

        return new ResponseEntity<>(rewards, HttpStatus.OK);
    }

    @RequestMapping(value = "/retrieve-customer-rewards-by-month", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<Rewards> retrieveRewardsByMonth(@RequestParam(required = true) String email, @RequestParam(required = true) int month) {

        Rewards rewards = rewardService.calculateRewardsForMonth(email, month);

        return new ResponseEntity<>(rewards, HttpStatus.OK);
    }
}
