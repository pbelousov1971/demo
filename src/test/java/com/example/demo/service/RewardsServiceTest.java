package com.example.demo.service;

import com.example.demo.entity.Rewards;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RewardsServiceTest {

    @Autowired
    RewardsService rewardsService;

    @Test
    void calculateTotalRewards() {
        Rewards result = rewardsService.calculateTotalRewards("test@email.com");

        assertEquals(90, result.getCustomerRewards());
        assertEquals("test@email.com", result.getCustomerEmail());
    }

    @Test
    void calculateRewardsForMonth() {
        Rewards result = rewardsService.calculateRewardsForMonth("email@email.com", 10);

        assertEquals(350, result.getCustomerRewards());
        assertEquals("email@email.com", result.getCustomerEmail());
    }

    @Test
    void calculateRewardsForMonthWithWrongEmail() {
        Rewards result = rewardsService.calculateRewardsForMonth("email111@email.com", 10);

        assertEquals(0, result.getCustomerRewards());
        assertEquals("email111@email.com", result.getCustomerEmail());
    }
}