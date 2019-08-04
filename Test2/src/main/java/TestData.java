import com.ebay.xcelite.annotations.Column;


public class TestData {

    private String requestType = "sale";

    private String userName = "test_api_user";

    private String password = "U06hJC2AUc53aSA7M3R22hA30Be1F1lF";

    private Integer accountId = 2001;

    @Column (name = "amount")
    private Integer amount;

    private String accountType = "R";

    private String transactionIndustryType = "RE";

    private String accountNumber = "4111111111111111";

    private String accountAccessory = "0422";

    @Column (name = "accountData")
    private String accountData;

    @Column (name = "customerAccountCode")
    private String customerAccountCode;

    @Column (name = "transactionCode")
    private String transactionCode;

    @Column (name = "zipCode")
    private String zipCode;

    @Column (name = "csc")
    private String csc;

    @Override
    public String toString() {
        return "requestType=" + requestType +
                "&userName=" + userName +
                "&password=" + password +
                "&accountId=" + accountId +
                "&amount=" + amount +
                "&accountType=" + accountType +
                "&transactionIndustryType=" + transactionIndustryType +
                "&accountNumber=" + accountNumber +
                "&accountData=" + accountData +
                "&customerAccountCode=" + customerAccountCode +
                "&transactionCode=" + transactionCode +
                "&accountAccessory=" + accountAccessory +
                "&zipCode=" + zipCode +
                "&cscCode=" + csc;
    }
}
