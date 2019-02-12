import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Sale {

    private double saleAmount;
    private AgentNode salesAgent;
    private Plan salesPlan;

    public double getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(double saleAmount) {
        this.saleAmount = saleAmount;
    }

    public AgentNode getSalesAgent() {
        return salesAgent;
    }

    public void setSalesAgent(AgentNode salesAgent) {
        this.salesAgent = salesAgent;
    }

    public Plan getSalesPlan() {
        return salesPlan;
    }

    public void setSalesPlan(Plan salesPlan) {
        this.salesPlan = salesPlan;
    }

    public double calculateCommission() {
        int level = 0;
        double commission = 0.0;
        List<Double> salesPlanCommissions = salesPlan.getCommissions();
        Queue<AgentNode> queue = new LinkedList<AgentNode>();

        queue.add(salesAgent);

        while (!queue.isEmpty()) {
            AgentNode currentNode = queue.remove();
            double salesPlanCommissionAtGivenLevel = level < salesPlanCommissions.size() ? salesPlanCommissions.get(level) : 0.0;
            commission += salesPlanCommissionAtGivenLevel * currentNode.getCommission() * saleAmount;
            AgentNode currentNodeParent = currentNode.getParent();
            if (currentNodeParent != null) {
                queue.add(currentNodeParent);
            }
            level++;
        }

        return commission;

    }
}
