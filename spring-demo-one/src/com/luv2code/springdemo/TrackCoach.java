package com.luv2code.springdemo;

public class TrackCoach implements Coach {
	private FortuneService fortuneService;
	public TrackCoach() {
		
	}
		 
	

	public TrackCoach(FortuneService fortuneService) {
		
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "just Do it: "+ fortuneService.getFortune();
	}
	
	//add an init method
	public void myStartup() {
		System.out.println("Track Coach: I am inside method myStartup");
	}
	
	//add a destroy method
	public void delmyStartup() {
		System.out.println("Track Coach: I am inside method delmyStartup");
	}

}
