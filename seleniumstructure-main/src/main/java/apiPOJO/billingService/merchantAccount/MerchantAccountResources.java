package apiPOJO.billingService.merchantAccount;

public enum MerchantAccountResources {

    updateVMPIRegistrationStatus("/api/merchant-accounts/%s/vmpi-status"),
    searchMerchantAccount("/api/merchant-accounts?%s"),
    showMerchantAccount("/api/merchant-accounts/%s"),
    createMerchantAccount("/api/merchant-accounts"),
    updateMerchantAccount("/api/merchant-accounts/%s"),
    deleteMerchantAccount("/api/merchant-accounts/%s");

    private String resource;

    MerchantAccountResources(String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }

    public String getResource(String additionalResource) {
        return String.format(resource, additionalResource);
    }
    
}
