package lesson3;

import java.util.ArrayList;
import java.util.List;

public class Companies {
    private List<Company> companies;

    public Companies() {
        this.companies = new ArrayList<>();
    }

    public Companies(List<Company> companies) {
        this.companies = companies;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }
}
