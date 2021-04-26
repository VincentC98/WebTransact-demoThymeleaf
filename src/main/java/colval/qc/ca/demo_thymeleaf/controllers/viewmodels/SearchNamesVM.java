package colval.qc.ca.demo_thymeleaf.controllers.viewmodels;

public class SearchNamesVM {

    private String subFirstName;

    public SearchNamesVM(String firstname) {
        this.subFirstName = firstname;
    }

    public SearchNamesVM() {
    }

    public String getFirstname() {
        return subFirstName;
    }

    public void setFirstname(String firstname) {
        this.subFirstName = firstname;
    }

    @Override
    public String toString() {
        return "SearchNamesVM{" +
                "name='" + subFirstName + '\'' +
                '}';
    }
}

