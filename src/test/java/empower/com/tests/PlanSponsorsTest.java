package empower.com.tests;

import empower.com.common.BaseTest;
import empower.com.pages.IndividualsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlanSponsorsTest extends BaseTest {

    @Test
    public void testMainHeadingIndividualsPage() {
        String actualHeading = new IndividualsPage(getDriver())
                .clickPlanSponsorsMenu()
                .getTextOfMainHeading();

        Assert.assertEquals(actualHeading, "Get good at money");
    }


}
