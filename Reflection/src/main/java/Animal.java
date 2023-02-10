public abstract class Animal {
    public String name;
    private String breed;
    protected String gender;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

        public void cat (String name, String breed, String gender){
            this.name = name;
            this.breed = breed;
            this.gender = gender;

        }
    }
