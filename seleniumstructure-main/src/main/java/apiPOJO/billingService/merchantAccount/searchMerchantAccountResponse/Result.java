package apiPOJO.billingService.merchantAccount.searchMerchantAccountResponse;

public  class Result {

    private Integer id;
    private String reference;
    private PaymentGateway payment_gateway;
    private AcquiringBank acquiring_bank;
    private String acquirer_bin_visa_card;
    private Website website;
    private String descriptor_line_1;
    private String descriptor_line_2;
    private Client client;
    private Integer mode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public PaymentGateway getPayment_gateway() {
        return payment_gateway;
    }

    public void setPayment_gateway(PaymentGateway payment_gateway) {
        this.payment_gateway = payment_gateway;
    }

    public AcquiringBank getAcquiring_bank() {
        return acquiring_bank;
    }

    public void setAcquiring_bank(AcquiringBank acquiring_bank) {
        this.acquiring_bank = acquiring_bank;
    }

    public String getAcquirer_bin_visa_card() {
        return acquirer_bin_visa_card;
    }

    public void setAcquirer_bin_visa_card(String acquirer_bin_visa_card) {
        this.acquirer_bin_visa_card = acquirer_bin_visa_card;
    }

    public Website getWebsite() {
        return website;
    }

    public void setWebsite(Website website) {
        this.website = website;
    }

    public String getDescriptor_line_1() {
        return descriptor_line_1;
    }

    public void setDescriptor_line_1(String descriptor_line_1) {
        this.descriptor_line_1 = descriptor_line_1;
    }

    public String getDescriptor_line_2() {
        return descriptor_line_2;
    }

    public void setDescriptor_line_2(String descriptor_line_2) {
        this.descriptor_line_2 = descriptor_line_2;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Integer getMode() {
        return mode;
    }

    public void setMode(Integer mode) {
        this.mode = mode;
    }

}
