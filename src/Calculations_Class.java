public class Calculations_Class {


    private String zahl;
    private String zahl1;
    private String ergebnis;
    private String operator;


    public Calculations_Class(){
           this.zahl = "";
           this.zahl1 = "";
           this.ergebnis = "";
            this.operator = "";
    }



    public String getZahl() {
        return zahl;
    }

    public void setZahl(String zahl) {
        this.zahl = zahl;
    }

    public String getErgebnis() {
        return ergebnis;
    }

    public void setErgebnis(String ergebnis) {
        this.ergebnis = ergebnis;
    }

    public String getZahl1() {
        return zahl1;
    }

    public void setZahl1(String zahl1) {
        this.zahl1 = zahl1;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }


    @Override
    public String toString() {
        return "{" +
                "zahl=" + zahl +
                ", operator='" + operator +
                ", zahl1=" + zahl1 +
                ", ergebnis=" + ergebnis +
                '}';
    }



    public String addition(String zahl, String zahl1) {

        double summe =  (Double.parseDouble(zahl) + Double.parseDouble(zahl1));
        return this.ergebnis = String.valueOf(summe);
    }

    public String substraktion(String zahl, String zahl1){
        double summe =  (Double.parseDouble(zahl) - Double.parseDouble(zahl1));
        return  this.ergebnis = String.valueOf(summe);
    }

    public String multiplikation(String zahl,String zahl1){
        double summe =  (Double.parseDouble(zahl) * Double.parseDouble(zahl1));
        return  this.ergebnis = String.valueOf(summe);
    }

    public String division(String zahl, String zahl1){
        final double number = Double.parseDouble(zahl);
        //try catch(Arithemtic exception throwen)
        if(number <0){
            return "kann nicht durch null teilen";
        }else {
            final double summe = Double.parseDouble(zahl) / Double.parseDouble(zahl1);
            return this.ergebnis = String.valueOf(summe);
        }
    }


    public String deleteLastNumberZahl(String var){

        String newStr = "";
        final char [] tmp = var.toCharArray();
        if(var.length()>1){
            for (int i = 0; i < tmp.length-1; i++) {
                newStr+=tmp[i];
            }
            return newStr;
        }
        return var;
    }

}
