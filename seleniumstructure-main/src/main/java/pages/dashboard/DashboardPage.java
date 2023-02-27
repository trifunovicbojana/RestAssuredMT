package pages.dashboard;

import com.sixsentix.qa.util.FunctionsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;


import java.util.HashMap;

public class DashboardPage extends FunctionsPage {

    public DashboardPage(WebDriver driver, String state) {
        super(driver);
        initMap(state); //ToDo -> second way to init map through constructor, this one is more optimized.
    }

    SoftAssert softAssert = new SoftAssert();
    HashMap<String, By> mapOfPageElements = new HashMap<>();

    private void initMap(String state) {
        switch (state) {
            case "sidebarPaymentsDropdown":
                mapOfPageElements.put("responseCodeOverview", By.xpath("//*[@qa-id='sidebarPayments_ResponseCodeOverview']"));
                mapOfPageElements.put("processingStatementText", By.xpath("//*[@qa-id='sidebarPayments_ProcessingStatement']"));
                mapOfPageElements.put("paymentsListText", By.xpath("//*[@qa-id='sidebarPayments_PaymentsList']"));
                break;
            case "sidebarSubscriptionsDropdown":
                mapOfPageElements.put("subscriptionsListText", By.xpath("//*[@qa-id='sidebarSubscriptions_SubscriptionsList']"));
                mapOfPageElements.put("reBillingStatistics", By.xpath("//*[@qa-id='sidebarSubscriptions_ReBillingStatistics']"));
                break;
            case "client":
                mapOfPageElements.put("logo", By.xpath("//*[@qa-id='emailInputField']"));
                mapOfPageElements.put("dashboardIcon", By.xpath("//*[@qa-id='dashboardIcon']"));
                mapOfPageElements.put("profileIcon", By.xpath("//*[@qa-id='profileIcon']"));
                mapOfPageElements.put("sidebarProfileText", By.xpath("//*[@qa-id='sidebarProfileText']"));
                mapOfPageElements.put("paymentsIcon", By.xpath("//*[@qa-id='paymentsIcon']"));
                mapOfPageElements.put("subscriptionIcon", By.xpath("//*[@qa-id='subscriptionIcon']"));
                mapOfPageElements.put("customersIcon", By.xpath("//*[@qa-id='customersIcon']"));
                mapOfPageElements.put("disputeIcon", By.xpath("//*[@qa-id='disputeIcon']"));
                mapOfPageElements.put("fraudMitigationIcon", By.xpath("//*[@qa-id='fraudMitigationIcon']"));
                mapOfPageElements.put("configurationIcon", By.xpath("//*[@qa-id='configurationIcon']"));
                mapOfPageElements.put("tppText", By.xpath("//*[@qa-id='tppText']"));
                mapOfPageElements.put("sidebarDashboardText", By.xpath("//*[@qa-id='sidebarDashboardText']"));
                mapOfPageElements.put("sidebarPaymentsText", By.xpath("//*[@qa-id='sidebarPaymentsText']"));
                mapOfPageElements.put("sidebarSubscriptionsText", By.xpath("//*[@qa-id='sidebarSubscriptionsText']"));
                mapOfPageElements.put("sidebarCustomersText", By.xpath("//*[@qa-id='sidebarCustomersText']"));
                mapOfPageElements.put("sidebarDisputeText", By.xpath("//*[@qa-id='sidebarDisputeText']"));
                mapOfPageElements.put("sidebarDisputeDropdownClient", By.xpath("//*[@qa-id='sidebarDisputeDropdown']"));
                mapOfPageElements.put("sidebarFraudMitigationText", By.xpath("//*[@qa-id='sidebarFraudMitigationText']"));
                mapOfPageElements.put("sidebarFraudMitigationDropdownClient", By.xpath("//*[@qa-id='sidebarFraudMitigationDropdown']"));
                mapOfPageElements.put("sidebarConfigurationText", By.xpath("//*[@qa-id='sidebarConfigurationText']"));
                mapOfPageElements.put("sidebarPaymentsDropdown", By.xpath("//*[@qa-id='sidebarPaymentsDropdown']"));
                mapOfPageElements.put("sidebarSubscriptionsDropdown", By.xpath("//*[@qa-id='sidebarSubscriptionsDropdown']"));
                mapOfPageElements.put("sidebarConfigurationDropdown", By.xpath("//*[@qa-id='sidebarConfigurationDropdown']"));
                mapOfPageElements.put("dashboardDashboardText", By.xpath("//*[@qa-id='dashboardDashboardText']"));
                mapOfPageElements.put("captureAndAuthorizedContainer", By.xpath("//*[@qa-id='captureAndAuthorizedContainer']"));
                mapOfPageElements.put("captureAndAuthorizedContainer_CaptureVolumeText", By.xpath("//*[@qa-id='captureAndAuthorizedContainer_CaptureVolumeText']"));
                mapOfPageElements.put("captureAndAuthorizedContainer_CaptureVolumeAmount", By.xpath("//*[@qa-id='captureAndAuthorizedContainer_CaptureVolumeAmount']"));
                mapOfPageElements.put("captureAndAuthorizedContainer_AuthorizedVolumeText", By.xpath("//*[@qa-id='captureAndAuthorizedContainer_AuthorizedVolumeText']"));
                mapOfPageElements.put("captureAndAuthorizedContainer_AuthorizedVolumeAmount", By.xpath("//*[@qa-id='captureAndAuthorizedContainer_AuthorizedVolumeAmount']"));
                mapOfPageElements.put("captureAndAuthorizedContainer_TotalSalesVolumeForSelectedPeriodHyperlink", By.xpath("//*[@qa-id='captureAndAuthorizedContainer_TotalSalesVolumeForSelectedPeriodHyperlink']"));
                mapOfPageElements.put("captureAndAuthorizedContainer_RefundText", By.xpath("//*[@qa-id='captureAndAuthorizedContainer_RefundText']"));
                mapOfPageElements.put("captureAndAuthorizedContainer_RefundAmount", By.xpath("//*[@qa-id='captureAndAuthorizedContainer_RefundAmount']"));
                mapOfPageElements.put("paymentTrendsContainer", By.xpath("//*[@qa-id='paymentTrendsContainer']"));
                mapOfPageElements.put("paymentTrendsContainer_Description", By.xpath("//*[@qa-id='paymentTrendsContainer_Description']"));
                mapOfPageElements.put("paymentTrendsContainer_CapturedIcon", By.xpath("//*[@qa-id='paymentTrendsContainer_CapturedIcon']"));
                mapOfPageElements.put("paymentTrendsContainer_CapturedText", By.xpath("//*[@qa-id='paymentTrendsContainer_CapturedText']"));
                mapOfPageElements.put("paymentTrendsContainer_DisputeIcon", By.xpath("//*[@qa-id='paymentTrendsContainer_DisputeIcon']"));
                mapOfPageElements.put("paymentTrendsContainer_DisputeText", By.xpath("//*[@qa-id='paymentTrendsContainer_DisputeText']"));
                mapOfPageElements.put("paymentTrendsContainer_RefundIcon", By.xpath("//*[@qa-id='paymentTrendsContainer_RefundIcon']"));
                mapOfPageElements.put("paymentTrendsContainer_RefundText", By.xpath("//*[@qa-id='paymentTrendsContainer_RefundText']"));
                mapOfPageElements.put("customersContainer", By.xpath("//*[@qa-id='customersContainer']"));
                mapOfPageElements.put("customersContainer_CustomersTitle", By.xpath("//*[@qa-id='customersContainer_CustomersTitle']"));
                mapOfPageElements.put("customersContainer_CustomersNumber", By.xpath("//*[@qa-id='customersContainer_CustomersNumber']"));
                mapOfPageElements.put("customersContainer_SelectPeriodHyperlink", By.xpath("//*[@qa-id='customersContainer_SelectPeriodHyperlink']"));
                mapOfPageElements.put("approveRatioContainer", By.xpath("//*[@qa-id='approveRatioContainer']"));
                mapOfPageElements.put("approveRatioContainer_Title", By.xpath("//*[@qa-id='approveRatioContainer_Title']"));
                mapOfPageElements.put("approveRatioContainer_Percentage", By.xpath("//*[@qa-id='approveRatioContainer_Percentage']"));
                mapOfPageElements.put("approveRatioContainer_SelectedPeriodHyperlink", By.xpath("//*[@qa-id='approveRatioContainer_SelectedPeriodHyperlink']"));
                mapOfPageElements.put("paymentsAuthorizedContainer", By.xpath("//*[@qa-id='paymentsAuthorizedContainer']"));
                mapOfPageElements.put("paymentsAuthorizedContainer_Title", By.xpath("//*[@qa-id='paymentsAuthorizedContainer_Title']"));
                mapOfPageElements.put("paymentsAuthorizedContainer_Number", By.xpath("//*[@qa-id='paymentsAuthorizedContainer_Number']"));
                mapOfPageElements.put("paymentsAuthorizedContainer_TotalPaymentsHyperlink", By.xpath("//*[@qa-id='paymentsAuthorizedContainer_TotalPaymentsHyperlink']"));
                mapOfPageElements.put("activeSubscriptionsContainer", By.xpath("//*[@qa-id='activeSubscriptionsContainer']"));
                mapOfPageElements.put("activeSubscriptionsContainer_Title", By.xpath("//*[@qa-id='activeSubscriptionsContainer_Title']"));
                mapOfPageElements.put("activeSubscriptionsContainer_Number", By.xpath("//*[@qa-id='activeSubscriptionsContainer_Number']"));
                mapOfPageElements.put("activeSubscriptionsContainer_SelectedPeriodHyperlink", By.xpath("//*[@qa-id='activeSubscriptionsContainer_SelectedPeriodHyperlink']"));
                mapOfPageElements.put("filtersButton", By.xpath("//*[@qa-id='filtersButton']"));
                mapOfPageElements.put("logoutButton", By.xpath("//*[@qa-id='logoutButton']"));
                mapOfPageElements.put("clientNameText", By.xpath("//*[@qa-id='clientNameText']"));
                break;
            case "sidebarDisputeDropdownClient":
                mapOfPageElements.put("disputeList", By.xpath("//*[@qa-id='sidebarDispute_DisputeList']"));
                break;
            case "sidebarFraudMitigationDropdownClient":
                mapOfPageElements.put("bINBlocking", By.xpath("//*[@qa-id='sidebarFraudMitigation_BINBlocking']"));
                break;
            case "sidebarConfigurationDropdown":
                mapOfPageElements.put("subscriptionPlanConfiguration", By.xpath("//*[@qa-id='sidebarConfiguration_SubscriptionPlanConfiguration']"));
                mapOfPageElements.put("reBillingConfiguration", By.xpath("//*[@qa-id='sidebarConfiguration_ReBillingConfiguration']"));
                mapOfPageElements.put("merchantAccount", By.xpath("//*[@qa-id='sidebarConfiguration_MerchantAccount']"));
                mapOfPageElements.put("sidebarConfiguration_Webhooks", By.xpath("//*[@qa-id='sidebarConfiguration_Webhooks']"));
                break;
            case "admin":
                mapOfPageElements.put("logo", By.xpath("//*[@qa-id='emailInputField']"));
                mapOfPageElements.put("dashboardIcon", By.xpath("//*[@qa-id='dashboardIcon']"));
                mapOfPageElements.put("alertsIcon", By.xpath("//*[@qa-id='alertsIcon']"));
                mapOfPageElements.put("sidebarAlertsText", By.xpath("//*[@qa-id='sidebarAlertsText']"));
                mapOfPageElements.put("sidebarAlertsDropdown", By.xpath("//*[@qa-id='sidebarAlertsDropdown']"));
                mapOfPageElements.put("paymentsIcon", By.xpath("//*[@qa-id='paymentsIcon']"));
                mapOfPageElements.put("subscriptionIcon", By.xpath("//*[@qa-id='subscriptionIcon']"));
                mapOfPageElements.put("customersIcon", By.xpath("//*[@qa-id='customersIcon']"));
                mapOfPageElements.put("disputeIcon", By.xpath("//*[@qa-id='disputeIcon']"));
                mapOfPageElements.put("fraudMitigationIcon", By.xpath("//*[@qa-id='fraudMitigationIcon']"));
                mapOfPageElements.put("clientsIcon", By.xpath("//*[@qa-id='clientsIcon']"));
                mapOfPageElements.put("sidebarClientsText", By.xpath("//*[@qa-id='sidebarClientsText']"));
                mapOfPageElements.put("sidebarClientsDropdown", By.xpath("//*[@qa-id='sidebarClientsDropdown']"));
                mapOfPageElements.put("tppText", By.xpath("//*[@qa-id='tppText']"));
                mapOfPageElements.put("sidebarDashboardText", By.xpath("//*[@qa-id='sidebarDashboardText']"));
                mapOfPageElements.put("sidebarPaymentsText", By.xpath("//*[@qa-id='sidebarPaymentsText']"));
                mapOfPageElements.put("sidebarSubscriptionsText", By.xpath("//*[@qa-id='sidebarSubscriptionsText']"));
                mapOfPageElements.put("sidebarCustomersText", By.xpath("//*[@qa-id='sidebarCustomersText']"));
                mapOfPageElements.put("sidebarDisputeText", By.xpath("//*[@qa-id='sidebarDisputeText']"));
                mapOfPageElements.put("sidebarDisputeDropdownAdmin", By.xpath("//*[@qa-id='sidebarDisputeDropdown']"));
                mapOfPageElements.put("sidebarFraudMitigationText", By.xpath("//*[@qa-id='sidebarFraudMitigationText']"));
                mapOfPageElements.put("sidebarFraudMitigationDropdownAdmin", By.xpath("//*[@qa-id='sidebarFraudMitigationDropdown']"));
                mapOfPageElements.put("sidebarPaymentsDropdown", By.xpath("//*[@qa-id='sidebarPaymentsDropdown']"));
                mapOfPageElements.put("sidebarSubscriptionsDropdown", By.xpath("//*[@qa-id='sidebarSubscriptionsDropdown']"));
                mapOfPageElements.put("dashboardDashboardText", By.xpath("//*[@qa-id='dashboardDashboardText']"));
                mapOfPageElements.put("captureAndAuthorizedContainer", By.xpath("//*[@qa-id='captureAndAuthorizedContainer']"));
                mapOfPageElements.put("captureAndAuthorizedContainer_CaptureVolumeText", By.xpath("//*[@qa-id='captureAndAuthorizedContainer_CaptureVolumeText']"));
                mapOfPageElements.put("captureAndAuthorizedContainer_CaptureVolumeAmount", By.xpath("//*[@qa-id='captureAndAuthorizedContainer_CaptureVolumeAmount']"));
                mapOfPageElements.put("captureAndAuthorizedContainer_AuthorizedVolumeText", By.xpath("//*[@qa-id='captureAndAuthorizedContainer_AuthorizedVolumeText']"));
                mapOfPageElements.put("captureAndAuthorizedContainer_AuthorizedVolumeAmount", By.xpath("//*[@qa-id='captureAndAuthorizedContainer_AuthorizedVolumeAmount']"));
                mapOfPageElements.put("captureAndAuthorizedContainer_TotalSalesVolumeForSelectedPeriodHyperlink", By.xpath("//*[@qa-id='captureAndAuthorizedContainer_TotalSalesVolumeForSelectedPeriodHyperlink']"));
                mapOfPageElements.put("captureAndAuthorizedContainer_RefundText", By.xpath("//*[@qa-id='captureAndAuthorizedContainer_RefundText']"));
                mapOfPageElements.put("captureAndAuthorizedContainer_RefundAmount", By.xpath("//*[@qa-id='captureAndAuthorizedContainer_RefundAmount']"));
                mapOfPageElements.put("paymentTrendsContainer", By.xpath("//*[@qa-id='paymentTrendsContainer']"));
                mapOfPageElements.put("paymentTrendsContainer_Description", By.xpath("//*[@qa-id='paymentTrendsContainer_Description']"));
                mapOfPageElements.put("paymentTrendsContainer_CapturedIcon", By.xpath("//*[@qa-id='paymentTrendsContainer_CapturedIcon']"));
                mapOfPageElements.put("paymentTrendsContainer_CapturedText", By.xpath("//*[@qa-id='paymentTrendsContainer_CapturedText']"));
                mapOfPageElements.put("paymentTrendsContainer_DisputeIcon", By.xpath("//*[@qa-id='paymentTrendsContainer_DisputeIcon']"));
                mapOfPageElements.put("paymentTrendsContainer_DisputeText", By.xpath("//*[@qa-id='paymentTrendsContainer_DisputeText']"));
                mapOfPageElements.put("paymentTrendsContainer_RefundIcon", By.xpath("//*[@qa-id='paymentTrendsContainer_RefundIcon']"));
                mapOfPageElements.put("paymentTrendsContainer_RefundText", By.xpath("//*[@qa-id='paymentTrendsContainer_RefundText']"));
                mapOfPageElements.put("customersContainer", By.xpath("//*[@qa-id='customersContainer']"));
                mapOfPageElements.put("customersContainer_CustomersTitle", By.xpath("//*[@qa-id='customersContainer_CustomersTitle']"));
                mapOfPageElements.put("customersContainer_CustomersNumber", By.xpath("//*[@qa-id='customersContainer_CustomersNumber']"));
                mapOfPageElements.put("customersContainer_SelectPeriodHyperlink", By.xpath("//*[@qa-id='customersContainer_SelectPeriodHyperlink']"));
                mapOfPageElements.put("approveRatioContainer", By.xpath("//*[@qa-id='approveRatioContainer']"));
                mapOfPageElements.put("approveRatioContainer_Title", By.xpath("//*[@qa-id='approveRatioContainer_Title']"));
                mapOfPageElements.put("approveRatioContainer_Percentage", By.xpath("//*[@qa-id='approveRatioContainer_Percentage']"));
                mapOfPageElements.put("approveRatioContainer_SelectedPeriodHyperlink", By.xpath("//*[@qa-id='approveRatioContainer_SelectedPeriodHyperlink']"));
                mapOfPageElements.put("paymentsAuthorizedContainer", By.xpath("//*[@qa-id='paymentsAuthorizedContainer']"));
                mapOfPageElements.put("paymentsAuthorizedContainer_Title", By.xpath("//*[@qa-id='paymentsAuthorizedContainer_Title']"));
                mapOfPageElements.put("paymentsAuthorizedContainer_Number", By.xpath("//*[@qa-id='paymentsAuthorizedContainer_Number']"));
                mapOfPageElements.put("paymentsAuthorizedContainer_TotalPaymentsHyperlink", By.xpath("//*[@qa-id='paymentsAuthorizedContainer_TotalPaymentsHyperlink']"));
                mapOfPageElements.put("activeSubscriptionsContainer", By.xpath("//*[@qa-id='activeSubscriptionsContainer']"));
                mapOfPageElements.put("activeSubscriptionsContainer_Title", By.xpath("//*[@qa-id='activeSubscriptionsContainer_Title']"));
                mapOfPageElements.put("activeSubscriptionsContainer_Number", By.xpath("//*[@qa-id='activeSubscriptionsContainer_Number']"));
                mapOfPageElements.put("activeSubscriptionsContainer_SelectedPeriodHyperlink", By.xpath("//*[@qa-id='activeSubscriptionsContainer_SelectedPeriodHyperlink']"));
                mapOfPageElements.put("filtersButton", By.xpath("//*[@qa-id='filtersButton']"));
                mapOfPageElements.put("logoutButton", By.xpath("//*[@qa-id='logoutButton']"));
                mapOfPageElements.put("adminNameText", By.xpath("//*[@qa-id='adminNameText']"));
                mapOfPageElements.put("alertsNotificationText", By.xpath("//*[@qa-id='alertsNotificationText']"));
                mapOfPageElements.put("alertsNotificationIcon", By.xpath("//*[@qa-id='alertsNotificationIcon']"));
                break;
            case "sidebarDisputeDropdownAdmin":
                mapOfPageElements.put("disputeList", By.xpath("//*[@qa-id='sidebarDispute_DisputeList']"));
                mapOfPageElements.put("sidebarDispute_DisputeUpload", By.xpath("//*[@qa-id='sidebarDispute_DisputeUpload']"));
                break;
            case "sidebarFraudMitigationDropdownAdmin":
                mapOfPageElements.put("bINBlocking", By.xpath("//*[@qa-id='sidebarFraudMitigation_BINBlocking']"));
                mapOfPageElements.put("sidebarFraudMitigation_NegativeListMatchers", By.xpath("//*[@qa-id='sidebarFraudMitigation_NegativeListMatchers']"));
                break;
            case "sidebarAlertsDropdown":
                mapOfPageElements.put("sidebarAlerts_AlertsList", By.xpath("//*[@qa-id='sidebarAlerts_AlertsList']"));
                mapOfPageElements.put("sidebarAlerts_ResponseCodeMapping", By.xpath("//*[@qa-id='sidebarAlerts_ResponseCodeMapping']"));
                break;
            case "sidebarClientsDropdown":
                mapOfPageElements.put("sidebarClients_ClientsList", By.xpath("//*[@qa-id='sidebarClients_ClientsList']"));
                mapOfPageElements.put("sidebarClients_ClientsSetup", By.xpath("//*[@qa-id='sidebarClients_ClientsSetup']"));
                mapOfPageElements.put("sidebarClients_ClientsSetupDropdown", By.xpath("//*[@qa-id='sidebarClients_ClientsSetupDropdown']"));
                break;
            case "sidebarClients_ClientsSetupDropdown":
                mapOfPageElements.put("sidebarClients_ClientsSetup_SubPlanConfig", By.xpath("//*[@qa-id='sidebarClients_ClientsSetup_SubPlanConfig']"));
                mapOfPageElements.put("sidebarClients_ClientsSetup_ReBillingConfig", By.xpath("//*[@qa-id='sidebarClients_ClientsSetup_ReBillingConfig']"));
                mapOfPageElements.put("sidebarClients_ClientsSetup_MerchantAccount", By.xpath("//*[@qa-id='sidebarClients_ClientsSetup_MerchantAccount']"));
                mapOfPageElements.put("sidebarClients_ClientsSetup_AcquiringBank", By.xpath("//*[@qa-id='sidebarClients_ClientsSetup_AcquiringBank']"));
                mapOfPageElements.put("sidebarClients_ClientsSetup_Company", By.xpath("//*[@qa-id='sidebarClients_ClientsSetup_Company']"));
                mapOfPageElements.put("sidebarClients_ClientsSetup_Website", By.xpath("//*[@qa-id='sidebarClients_ClientsSetup_Website']"));
                mapOfPageElements.put("sidebarClients_ClientsSetup_Webhooks", By.xpath("//*[@qa-id='sidebarClients_ClientsSetup_Webhooks']"));
                break;
            default:
                break;
        }
    }

    public void checkAllElements() {
        checkIfPageContainsAllElements(mapOfPageElements, softAssert);
    }

}
