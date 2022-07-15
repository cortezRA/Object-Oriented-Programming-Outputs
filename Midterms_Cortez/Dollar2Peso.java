package Midterms_Cortez;

import java.text.DecimalFormat;

public class Dollar2Peso implements CurrencyExchange{
    private double amountI; // initial amount
    private double amountE; // equivalent amount
    DecimalFormat df = new DecimalFormat("#,###,###,##0.00");

    public Dollar2Peso(double amount){
        this.amountI = amount; //set initial amount 
        this.amountE = amount*56.30; //1 dollar equivalent to 56.30 pesos
        printDetails();
    }// end constructor

    public String getICurrency(){
        return "Dollar Amount: ";
    }// end String getICurrency

    public double getEAmount(){
        return amountE; // return equivalent peso amount
    }// end double getEAmount (getter)

    public double getIAmount(){
        return amountI; // return initial dollar amount
    }// end double getIAmount (getter)

    public void setIAmount(double amountI){
        this.amountI = amountI; // set up initial dollar amount
    }// end void setIAmount (setter)

    public String getDetails(){
        return "Exchanging dollar amount to peso...";
    }// end String getDetails

    public String getECurrency(){
        return "Peso Equivalent: ";
    }// end String getECurrency

    public void printDetails(){
        System.out.println(getDetails() + "\n\n" + getICurrency() + df.format(getIAmount()) + " dollar/s\n"
                           + getECurrency() + df.format(getEAmount()) + " peso/s\n");
    }// end void printDetails
}
