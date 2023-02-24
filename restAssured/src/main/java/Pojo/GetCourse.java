package Pojo;

public class GetCourse {
    private String url;
    private String services;
    private Courses Courses;
    private String instructor;
    private String linkedin;

    public Pojo.Courses getCourses() {
        return Courses;
    }

    public void setCourses(Pojo.Courses courses) {
        this.Courses = courses;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getServices() {
        return services;
    }
    public void setServices(String services) {
        this.services = services;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

}
