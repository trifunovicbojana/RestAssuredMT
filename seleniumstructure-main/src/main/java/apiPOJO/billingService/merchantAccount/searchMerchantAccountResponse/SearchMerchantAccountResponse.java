package apiPOJO.billingService.merchantAccount.searchMerchantAccountResponse;


import java.util.ArrayList;
import java.util.List;

public class SearchMerchantAccountResponse  {

    private List<Result> result = new ArrayList<Result>();
    private Pagination pagination;

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }









}