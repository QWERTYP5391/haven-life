import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class SaleTest {

    @Test
    public void calculateCommission() {

        Plan firstPlan = new Plan();
        firstPlan.setId(0);
        firstPlan.setName("A");

        List<Double> commissionPlan = new ArrayList<Double>();
        commissionPlan.add(0.5);
        commissionPlan.add(0.05);
        firstPlan.setCommissions(commissionPlan);

        AgentNode salesAgent = new AgentNode();
        salesAgent.setTitle("Agent");
        salesAgent.setCommission(0.02);

        AgentNode superAgent1 = new AgentNode();
        superAgent1.setTitle("Super Agent");
        superAgent1.setCommission(0.025);

        AgentNode superAgent2 = new AgentNode();
        superAgent2.setTitle("Super Agent");
        superAgent2.setCommission(0.0325);

        AgentNode superAgent3 = new AgentNode();
        superAgent3.setTitle("Super Agent");
        superAgent3.setCommission(0.0225);


        salesAgent.setParent(superAgent1);
        superAgent1.setParent(superAgent2);
        superAgent2.setParent(superAgent3);

        Sale sale = new Sale();
        sale.setSaleAmount(100000);
        sale.setSalesPlan(firstPlan);
        sale.setSalesAgent(salesAgent);

        double calculatedCommission = sale.calculateCommission();

        double expected = 1125;
        assertThat(calculatedCommission, equalTo(expected));

    }
}