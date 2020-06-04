package com.luv2code.springdemo;

public class BaseballCoach implements Coach {
	//define private field for the dependency
	private FortuneService fortuneService;
	//define a constructor for dependency injection
	public BaseballCoach(FortuneService theFortuneService) {
		fortuneService=theFortuneService;
	}
	@Override
	public String getDailyWorkout() {
		return "spend 30 minutes of batting practice";
	}

	@Override
	public String getDailyFortune() {
		// use my fortuneservice to get a fortune
		return fortuneService.getFortune() ;
	}
	
	

}
