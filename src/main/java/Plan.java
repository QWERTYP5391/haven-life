import java.util.List;

public class Plan {

    private String name;
    private Integer id;
    private List<Double> commissions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Double> getCommissions() {
        return commissions;
    }

    public void setCommissions(List<Double> commissions) {
        this.commissions = commissions;
    }
}
