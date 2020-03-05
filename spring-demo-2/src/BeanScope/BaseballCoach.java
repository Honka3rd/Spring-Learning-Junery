package BeanScope;

public class BaseballCoach implements Coach{
		
	// literal field
	private String email;
	private String name;
	
	@Override
	public String getDailyWorkout() {
		return "30 mins baseball workout";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void initBean() {
		System.out.println("Bean has been invoked");
	}
	
	public void destoryBean() {
		System.out.println("Bean has been destoried");
	}
	
}
