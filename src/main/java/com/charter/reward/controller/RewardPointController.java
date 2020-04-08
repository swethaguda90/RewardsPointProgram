package com.charter.reward.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charter.reward.exception.RecordNotFoundException;
import com.charter.reward.service.RewardPointsService;

@RestController()
@RequestMapping("/rewards")
public class RewardPointController {

	@Autowired
	RewardPointsService rewardPointsService;

	@GetMapping("/{month}")
	public ResponseEntity<Integer> getRewardPointByMonth(@PathVariable String month) throws RecordNotFoundException {
		Integer reward = rewardPointsService.getRewardPointByMonth(month);
		return new ResponseEntity<Integer>(reward, HttpStatus.OK);
	}

	@GetMapping()
	public ResponseEntity<Integer> getTotalRewardPoint() {
		Integer totalRewards = rewardPointsService.getTotalRewards();
		return new ResponseEntity<Integer>(totalRewards, HttpStatus.OK);
	}
}
