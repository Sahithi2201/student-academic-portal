package vcube.Model;

public class Fee {

    private int id;
    private String username;
    private String feeType;
    private int amount;
    private String status;
    private String paidDate;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getFeeType() { return feeType; }
    public void setFeeType(String feeType) { this.feeType = feeType; }

    public int getAmount() { return amount; }
    public void setAmount(int amount) { this.amount = amount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getPaidDate() { return paidDate; }
    public void setPaidDate(String paidDate) { this.paidDate = paidDate; }
}
