package parallel.apiSteps;

import apiHandlers.ApiUtils;
import apiPOJO.billingService.merchantAccount.MerchantAccountResources;
import apiPOJO.billingService.merchantAccount.searchMerchantAccountResponse.SearchMerchantAccountResponse;
import io.restassured.response.Response;

import java.io.IOException;


public class BillingService extends ApiUtils {


    Response response;

    SearchMerchantAccountResponse[] merchantReferenceObj;

    String clientID;
    String merchantReference;

    /**
     * @param resource not mandatory but in some API calls necessary parameter which determines specific target.
     *                 For example if you wish to delete some user you would call DELETE API and specify his ID which is resource.
     */
    private void searchMerchantDataExtraction(String resource) throws IOException {
        response = GET(requestSpecificationForGETWithHeader(), MerchantAccountResources.searchMerchantAccount.getResource(resource), 200);
        merchantReferenceObj = getObjectMapper().readValue(response.asString(), SearchMerchantAccountResponse[].class);
        for (SearchMerchantAccountResponse searchMerchantAccountResponse : merchantReferenceObj) {
            merchantReference = searchMerchantAccountResponse.getResult().get(0).getReference();
            clientID = searchMerchantAccountResponse.getResult().get(0).getClient().getId().toString();
        }
    }



}
