package colval.qc.ca.demo_thymeleaf.controllers.viewmodels;

public class SearchNamesVM {

    private String firstname;

    public SearchNamesVM(String firstname) {
        this.firstname = firstname;
    }

    public SearchNamesVM() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public String toString() {
        return "SearchNamesVM{" +
                "name='" + firstname + '\'' +
                '}';
    }
}

