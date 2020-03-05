package BeanScope;

public class BasketballCoach implements Coach {
	
	private String name;
	private String email;

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "play basketball for 30 min ";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
