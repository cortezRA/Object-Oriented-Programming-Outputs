package Midterms_Cortez;

import java.text.DecimalFormat;

public class Peso2Euro {
    private double amountI; // initial amount
    private double amountE; // equivalent amount
    DecimalFormat df = new DecimalFormat("#,###,###,##0.00");

    public Peso2Euro(double amount){
        this.amountI = amount; //set initial amount 
        this.amountE = amount*0.018; //1 peso equivalent to 0.018 euros
        printDetails();
    }// end constructor

    public String getICurrency(){
        return "Peso Amount: ";
    }// end String getICurrency

    public double getEAmount(){
        return amountE; // return equivalent euro amount
    }// end double getEAmount (getter)

    public double getIAmount(){
        return amountI; // return initial peso amount
    }// end double getIAmount (getter)

    public void setIAmount(double amountI){
        this.amountI = amountI; // set up initial peso amount
    }// end void setIAmount (setter)

    public String getDetails(){
        return "Exchanging peso amount to euro...";
    }// end String getDetails

    public String getECurrency(){
        return "Euro Equivalent: ";
    }// end String getECurrency

    public void printDetails(){
        System.out.println(getDetails() + "\n\n" + getICurrency() + df.format(getIAmount()) + " peso/s\n"
                            + getECurrency() + df.format(getEAmount()) + " euro/s\n");
    }// end void printDetails
}
