package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import myCooking.BillingService;
import myCooking.Customer;
import static org.junit.Assert.*;

public class BillingSystem {
    Customer moe,james;
    BillingService billingService;
    boolean invoiceSent;
    String financialReport;

    @Given("a customer has completed a purchase")
    public void aCustomerHasCompletedAPurchase() {
        moe=new Customer("moe","moe@gmail.com");
        billingService=new BillingService(0,0);

        billingService.completePurchase(moe,175);
    }

    @When("the transaction is confirmed by the system")
    public void theTransactionIsConfirmedByTheSystem() {



        assertEquals(175.0,billingService.getTotalSales(),0.0);

    }

    @Then("the system should generate an invoice")
    public void theSystemShouldGenerateAnInvoice() {
        invoiceSent=billingService.invoice(moe,175);
    }

    @And("send it to the customer's email address")
    public void sendItToTheCustomerSEmailAddress() {
        assertTrue(invoiceSent);
    }

    @Given("the system has recorded sales and expense data for the current month")
    public void theSystemHasRecordedSalesAndExpenseDataForTheCurrentMonth() {
        james=new Customer("james","james@gmail.com");
        billingService=new BillingService(0,0);
        billingService.completePurchase(moe,175);

        billingService.completePurchase(james,200);
        billingService.recordExpanse(50);
        billingService.recordExpanse(30);

    }

    @When("the administrator requests a monthly financial report")
    public void theAdministratorRequestsAMonthlyFinancialReport() {
        assertNotNull(billingService);
        financialReport= billingService.financialReport();
    }

    @Then("the system should generate a report summarizing revenue and expenses")
    public void theSystemShouldGenerateAReportSummarizingRevenueAndExpenses() {
        if (financialReport==null || financialReport.isEmpty()) {
            throw new AssertionError("Monthly financial report was not generated");
        }
    }

    @And("the system should display the report")
    public void theSystemShouldDisplayTheReport() {
        System.out.println(financialReport);

    }
}
