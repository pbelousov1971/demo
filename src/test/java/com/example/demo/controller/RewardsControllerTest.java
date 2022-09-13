package com.example.demo.controller;

import com.example.demo.entity.Rewards;
import com.example.demo.service.RewardsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class RewardsControllerTest {

    @InjectMocks
    RewardsController rewardsController;

    @Mock
    RewardsService rewardService;

    @Test
    public void retrieveTotalRewards() {
        Rewards rewards = new Rewards();
        rewards.setCustomerEmail("email");
        rewards.setCustomerRewards(1);
        when(rewardService.calculateTotalRewards(anyString())).thenReturn(rewards);
        // when
        ResponseEntity<Rewards> result = rewardsController.retrieveTotalRewards("email");
        // then
        assertThat(result.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    public void retrieveRewardsByMonth() {
        Rewards rewards = new Rewards();
        rewards.setCustomerEmail("email");
        rewards.setCustomerRewards(1);
        when(rewardService.calculateRewardsForMonth(anyString(), anyInt())).thenReturn(rewards);
        // when
        ResponseEntity<Rewards> result = rewardsController.retrieveRewardsByMonth("email", 1);
        // then
        assertThat(result.getStatusCodeValue()).isEqualTo(200);
    }
}
