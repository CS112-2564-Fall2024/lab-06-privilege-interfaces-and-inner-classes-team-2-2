public class Person implements Comparable<Person> {
	class Identity {
		private String pronouns;
		private String background;

		public Identity(String pronouns, String backGround) {
			this.pronouns = pronouns;
			this.background = backGround;
		}

		public Identity() {
			this.pronouns = "None";
			this.background = "None";
		}

		@Override
		public String toString() {
			return this.pronouns + "\n" + this.background;
		}
	}
	// CONSTANT VARIABLES
	public static final String DEFAULT_NAME = "Jamie Doe";
	public static final String DEFAULT_STORY =  "Unknown";
	public static final int DEFAULT_PRIVILEGE = 100;

	// INSTANCE VARIABLES
	private String name, story;
	private int privilege;

	// CONSTRUCTORS	
	public Person(String name, String story, int privilege) {
		this.setAll(name, story, privilege);
	}
		
	public Person() {
		this(DEFAULT_NAME, DEFAULT_STORY, DEFAULT_PRIVILEGE);
	}
	
	public Person(Person original) {
		if(original == null) {
			throw new IllegalArgumentException("Cannot copy null obect in Person copy constructor");
		} else {
			this.setAll(original.name, original.story, original.privilege);
		}
	}

	// MUTATORS/SETTERS
	public void setName(String name) {
		this.name = name;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public void setPrivilege(int privilege) {
		this.privilege = privilege;
	}

	public void setAll(String name, String story, int privilege) {
		this.setPrivilege(privilege);
		this.setName(name);
		this.setStory(story);
	}

	// ACCESSORS / GETTERS
	public String getName() {
		return this.name;
	}
		
	public String getStory() {
		return this.story;
	}

	public int getPrivilege() {
		return this.privilege;
	}

	// OTHER REQUIRED METHODS
	@Override
	public String toString()
	{
		return "My name is "+ this.name + " and "+ this.story + "\n"
				+ "According to this calculator I ended up with "+ this.privilege + " estimated privilege points";
	}
	
	@Override
	public boolean equals(Object other) 
	{
		if(other == null || (!(other instanceof Person))) {
		      return false;
		}
		
		Person otherPerson = (Person) other;
		return this.name.equals(otherPerson.name) && this.story.equals(otherPerson.story) &&
			this.privilege == otherPerson.privilege;	
	}

	@Override
	public int compareTo(Person p) {
		if (this.getPrivilege() < p.getPrivilege()) {
			return -1;
		} else if (this.getPrivilege() > p.getPrivilege()) {
			return 1;
		} else {
			return 0;
		}
	}

}