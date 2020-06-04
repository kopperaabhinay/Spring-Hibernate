package com.luv2code.springdemo;

public class CricketCoach implements Coach {
	private FortuneService fortuneService;
	
	//add new fields
	private String emailAddress;
	private String team;
	
	
	public String getEmailAddress() {
		return emailAddress;
	}



	public void setEmailAddress(String emailAddress) {
		System.out.println("Cricket coach: inside setter method- set emailAddress");
		this.emailAddress = emailAddress;
	}



	public String getTeam() {
		return team;
	}



	public void setTeam(String team) {
		System.out.println("Cricket coach: inside setter method- set team");
		this.team = team;
	}



	//no arg constructor
	public CricketCoach() {
		System.out.println("Cricket coach inside no-arg");
	}
	
	

	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Cricket coach: inside setter method");
		this.fortuneService = fortuneService;
	}



	@Override
	public String getDailyWorkout() {
		
		return "Practice bowling for 15 minutes.";
	}

	@Override
	public String getDailyFortune() {
	
		return fortuneService.getFortune();
	}

}
