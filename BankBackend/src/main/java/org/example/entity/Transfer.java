package org.example.entity;
import javax.persistence.*;

@Entity
@Table(name = "transfers")

public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // 0
    private int transferTo;
    private int transferFrom;
    private String transferTime; //does this need a special char type?
    private int amount; // null


    public Transfer(int transferTo, String transferTime, int amount) {
        this.transferTo = transferTo;
        this.transferFrom = transferFrom;
        this.transferTime = transferTime;
        this.amount = amount;
    }

    public Transfer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTransferTo() {
        return transferTo;
    }

    public void setTransferTo(int TransferTo) {
        this.transferTo = transferTo;
    }

    public int getTransferFrom() {
        return transferFrom;
    }

    public void setTransferFrom(int TransferTo) { this.transferFrom = transferFrom;}


    public String getTransferTime(){
        return transferTime;
    }

    public void setTransferTime(String transferTime){
        this.transferTime = transferTime;
    }

    public int amount() {
        return amount;
    }

    public void setamount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "id=" + id +
                ", transferTo='" + transferTo + '\'' +
                ", transferTo='" + transferTo + '\'' +
                ", amount=" + amount +
                ", transferTime='"+ transferTime + '\''+
                '}';
    }
}
