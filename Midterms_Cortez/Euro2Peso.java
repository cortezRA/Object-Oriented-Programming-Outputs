package Midterms_Cortez;

import java.text.DecimalFormat;

public class Euro2Peso {
    private double amountI; // initial amount
    private double amountE; // equivalent amount
    DecimalFormat df = new DecimalFormat("#,###,###,##0.00");

    public Euro2Peso(double amount){
        this.amountI = amount; //set initial amount 
        this.amountE = amount*56.61; //1 euro equivalent to 56.61 pesos
        printDetails();
    }// end constructor

    public String getICurrency(){
        return "Euro Amount: ";
    }// end String getICurrency

    public double getEAmount(){
        return amountE; // return equivalent peso amount
    }// end double getEAmount (getter)

    public double getIAmount(){
        return amountI; // return initial euro amount
    }// end double getIAmount (getter)

    public void setIAmount(double amountI){
        this.amountI = amountI; // set up initial euro amount
    }// end void setIAmount (setter)

    public String getDetails(){
        return "Exchanging euro amount to peso...";
    }// end String getDetails

    public String getECurrency(){
        return "Peso Equivalent: ";
    }// end String getECurrency

    public void printDetails(){
        System.out.println(getDetails() + "\n\n" + getICurrency() + df.format(getIAmount()) + " euro/s\n"
                            + getECurrency() + df.format(getEAmount()) + " peso/s\n");
    }// end void printDetails
}
