import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Calculator_Window_Class  extends JFrame implements ActionListener {


     private static final double PI = Math.PI;
     //enums maybe ?
     private static final String PI_STRING = "\u03c0";
     private static final String SQ_ROOT  = "\u221a";

     private  JTextField screenLabel;
     private  final Calculations_Class calculations;
     private  JButton  point,squareRoot, pie, remove, b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, plus, minus, divide, multiply, delete, equals;



    public Calculator_Window_Class(){
        calculations = new Calculations_Class();
        screenLabel = new JTextField(15);
        screenLabel.setText("0");
    }




    public void calculatorWindow(){
        JFrame jFrame = new JFrame("My Calculator");
        jFrame.setSize(300,350);
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jFrame.add(createEingabenAnzeige(), BorderLayout.CENTER);
        jFrame.add(createTastenFeld(),BorderLayout.SOUTH);
        jFrame.setVisible(true);
    }


    /**
     * erzeuge das AnzeigeFeld für zum Berechnen als JtextField
     * @return
     */
    private JPanel createEingabenAnzeige(){

        final JPanel panel  = new JPanel();
        Font newTextFieldFont = new Font(screenLabel.getFont().getName(),screenLabel.getFont().getStyle(),20);
        panel.setLayout(new BorderLayout());

        screenLabel.setFont(newTextFieldFont);
        screenLabel.setSize(100,100);

        panel.add(screenLabel);

        return panel;
    }

    /**
     * erzeuge das Tastenfeld für den Rechner
     * @return
     */

    private JPanel createTastenFeld(){
        final JPanel panel = new JPanel();


        panel.setLayout(new GridLayout(5,3));

        point = new JButton(".");
        squareRoot = new JButton(SQ_ROOT);
        pie = new JButton(PI_STRING);
        remove = new JButton("x");

        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        plus= new JButton("+");

        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        minus = new JButton("-");

        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        multiply = new JButton("*");

        delete = new JButton("C");
        b0 = new JButton("0");
        equals = new JButton("=");
        divide = new JButton("/");


        point = new JButton(".");
        squareRoot = new JButton(SQ_ROOT);
        pie = new JButton(PI_STRING);
        remove = new JButton("<");

        for (final JButton jButton : Arrays.asList(b1, b2, b3, plus, b4, b5, b6, minus, b7, b8, b9, multiply, delete, b0, equals, divide, point,squareRoot, pie, remove)) {
            jButton.addActionListener(this);
        }

        panel.add(point);
        panel.add(squareRoot);
        panel.add(pie);
        panel.add(remove);

        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(plus);

        panel.add(b4);
        panel.add(b5);
        panel.add(b6);
        panel.add(minus);

        panel.add(b7);
        panel.add(b8);
        panel.add(b9);
        panel.add(multiply);

        panel.add(delete);
        panel.add(b0);
        panel.add(equals);
        panel.add(divide);


        return panel;
    }

    /**
     * Alle anweisungen hier rein
     * nicht die beste Idee aber......
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        //Speichern des aktuellen buttonTextes
        final String currentAction = e.getActionCommand();

        //Eingabe und was gemacht wird..... If, else if des todes
        if(currentAction.charAt(0) >= '0' && currentAction.charAt(0) <= '9'){

            if(calculations.getErgebnis().isEmpty()) {

                if (calculations.getOperator().isEmpty()) {
                    calculations.setZahl(calculations.getZahl() + currentAction);
                } else {
                    calculations.setZahl1(calculations.getZahl1() + currentAction);
                }

            }else{
                calculations.setZahl1("");
                calculations.setErgebnis("");
                if (!calculations.getOperator().isEmpty()) {
                    calculations.setZahl1(calculations.getZahl1() + currentAction);
                }
            }
            screenLabel.setText(calculations.getZahl() + calculations.getOperator() + calculations.getZahl1());
            //Lösche Alles
        }else if(currentAction.charAt(0) == 'C' ){

            setAllCalculationsValuesToZero();
            screenLabel.setText("0");
        //berechnung von zahl und zahl1
        }else if(currentAction.charAt(0) == '='){

            if(calculations.getOperator().equals("+")){
               calculations.setErgebnis(calculations.addition(calculations.getZahl(),calculations.getZahl1()));
               calculations.setZahl(calculations.getErgebnis());

            }else if(calculations.getOperator().equals("-")){
                calculations.setErgebnis(calculations.substraktion(calculations.getZahl(), calculations.getZahl1()));
                calculations.setZahl(calculations.getErgebnis());

            }else if(calculations.getOperator().equals("*")){
                calculations.setErgebnis(calculations.multiplikation(calculations.getZahl(), calculations.getZahl1()));
                calculations.setZahl(calculations.getErgebnis());

            }else if(calculations.getOperator().equals("/")){
                calculations.setErgebnis(calculations.division(calculations.getZahl(), calculations.getZahl1()));
                calculations.setZahl(calculations.getErgebnis());
                //calculations.setOperator("");
            }
            screenLabel.setText(calculations.getErgebnis());
            //setzen der operatoren
        }else if(currentAction.charAt(0) == '+' || currentAction.charAt(0) == '-' || currentAction.charAt(0) == '*' || currentAction.charAt(0) == '/'){
            calculations.setOperator(currentAction);
            //wenn pi genutzt wird
        }else if(currentAction.equals(PI_STRING)){

            if (calculations.getOperator().isEmpty()) {
                calculations.setZahl(String.valueOf(PI));
            } else {
                calculations.setZahl1(String.valueOf(PI));
            }
            screenLabel.setText(calculations.getZahl() + calculations.getOperator() + calculations.getZahl1());
        //lösche einzelne werte von zahl oder zahl1, falls es zu viele waren.
        // da derzeit kein komma genutzt wird, könnte es zu problemen kommen.....
        }else if(currentAction.charAt(0) == '<'){

                 if(!calculations.getZahl().isEmpty() && calculations.getOperator().isEmpty()){
                     calculations.setZahl(calculations.deleteLastNumberZahl(calculations.getZahl()));
                 }else{
                     calculations.setZahl1(calculations.deleteLastNumberZahl(calculations.getZahl1()));
                 }
            screenLabel.setText(calculations.getZahl() + calculations.getOperator() + calculations.getZahl1());
        }





    }

    /**
     * Methode zum zurücksetzen der Werte aus der Klasse Calculations_Class
     */
    private void setAllCalculationsValuesToZero(){
        calculations.setErgebnis("");
        calculations.setZahl("");
        calculations.setZahl1("");
        calculations.setOperator("");
    }


}
