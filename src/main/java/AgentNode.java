public class AgentNode {

    private String title;
    private double commission;
    private AgentNode parent;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public AgentNode getParent() {
        return parent;
    }

    public void setParent(AgentNode parent) {
        this.parent = parent;
    }
}
