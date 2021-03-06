//File name: JCalcFrame.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;
import java.math.RoundingMode;
import java.text.DecimalFormat;


public class JCalcFrame extends JFrame implements ActionListener
{
  //checks for checkbox bool
  boolean isChecked = false;
  
  FlowLayout flow = new FlowLayout();
  JLabel title = new JLabel("Mortgage Calculator");

  //creates menu bar w/ file menu item
  JMenuBar menu = new JMenuBar();
  JMenu file = new JMenu("File");
  JCheckBoxMenuItem userInputBool = new JCheckBoxMenuItem("User Input");

  //creates button to enter farenheit value
  JLabel principal = new JLabel("Mortgage principal");
  JLabel rate = new JLabel("Interest rate (%)");
  JLabel term = new JLabel("Mortgage term (years)");

  //user input text field
  JTextField userP = new JTextField("100000", 3);
  JTextField userT = new JTextField("30", 3);
  JTextField userR = new JTextField("5.35");

  //dropdown menu arrays
  double Rate[] = {5.35, 5.50, 5.75};
  int Term[] = {7, 15, 30};

  //dropdown for Rate + Term
  String Dropdown[] = {"7 years at 5.35%", "15 years at 5.50%", "30 years at 5.75%"};
  JComboBox dropdown = new JComboBox(Dropdown);

  JButton calcButton = new JButton("Calculate");
  JButton exitButton = new JButton("Exit");
  JButton reset = new JButton("Reset");

  JLabel result = new JLabel("Your monthly payment is: ");
  JLabel sum = new JLabel("  ");

  //makes boxes class variable
  Box col3;
  Box col2;
  Box row1;

  JTextArea textArea = new JTextArea(15, 40);
  JScrollPane displayScroll = new JScrollPane(textArea,
    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
    JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

  //creates the general look of the UI
  public JCalcFrame()
  {
    //creates a container with boxes inside for easy organization and spacing
    Container con = getContentPane();
    Box outer = Box.createVerticalBox();
    Box row0 = Box.createHorizontalBox();
    row1 = Box.createHorizontalBox();
    Box col1 = Box.createVerticalBox();
    col2 = Box.createVerticalBox();
    col3 = Box.createVerticalBox();
    Box row2 = Box.createHorizontalBox();
    Box col4 = Box.createVerticalBox();
    Box col5 = Box.createVerticalBox();
    Box col6 = Box.createVerticalBox();
    Box row3 = Box.createHorizontalBox();
    Box row4 = Box.createHorizontalBox();

    //sets container layout to flow
    con.setLayout(flow);
    con.add(menu);
    setJMenuBar(menu);
    menu.add(file);
    file.add(userInputBool);

    //creates heading title 22pt font
    title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
    title.setBorder(BorderFactory.createEmptyBorder(0,0,30,0));

    //creates boxes to organize the layout
    con.add(outer);
    outer.add(row0);
    //adds title
    row0.add(title);

    //adds row1 to outside container
    outer.add(row1);

    //adds 3 columns to row1
    row1.add(col1);
    row1.add(col2);
    row1.add(col3);

    //margin spacing
    //(top, left, bottom, right)
    col1.setBorder(BorderFactory.createEmptyBorder(0,0,0,10));
    col2.setBorder(BorderFactory.createEmptyBorder(0,0,0,10));
    
    //adds input title and text field to col1
    principal.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 13));
    principal.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
    col1.add(principal);
    userP.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
    userP.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
    col1.add(userP);

    //adds input title and text field to col2
    rate.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 13));
    rate.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
    col2.add(rate);
  
    //creates a styled JComboBox
    dropdown.setEditable(true);
    JTextField boxField = (JTextField)dropdown.getEditor().getEditorComponent();
    boxField.setBorder(BorderFactory.createEmptyBorder());
    dropdown.setBackground(new Color(0,0,0,0));
    dropdown.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
    dropdown.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15)); 
    col2.add(dropdown);

    //adds spacing and other components
    row2.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
    outer.add(row2);
    row2.add(col4);
    row2.add(col5);
    row2.add(col6);
    
    //adds spacing and calcButton
    sum.setBorder(BorderFactory.createEmptyBorder(0,0,20,0));

    //displays total monthly Mortgage
    col6.add(result);
    sum.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));
    col6.add(sum);

    //assigns calcButton, reset, and exit to its own row
    row3.setBorder(BorderFactory.createEmptyBorder(0,0,20,0));
    outer.add(row3);
    row3.add(calcButton);
    row3.add(reset);  
    row3.add(exitButton);

    //adds displayScroll
    outer.add(row4);
    row4.add(displayScroll);

    userInputBool.addActionListener(this);
    calcButton.addActionListener(this);
    exitButton.addActionListener(this);
    reset.addActionListener(this);
  }
  public void actionPerformed(ActionEvent e)
  {
     Object source = e.getSource();
     if(source == userInputBool) 
     {
        if(userInputBool.getState()) 
        {
          //removes the combobox
          col2.remove(dropdown);
          //styles text fields and labels
          term.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 13));
          term.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
          userT.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
          userT.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));

          //adds components
          col3.add(term);
          col3.add(userT);

          //styles text fields and labels
          rate.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 13));
          rate.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
          userR.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
          userR.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));

          //adds components
          col2.add(rate);
          col2.add(userR);

          //checkbox check = true
          isChecked = true;
        }
        else
        {
          //adds the combobox and removes the text fields
          col2.remove(userR);
          col3.remove(term);
          col3.remove(userT);
          col2.add(rate);
          col2.add(dropdown);

          isChecked = false;
        }

        //updates the UI
        row1.revalidate();
     }
     else if(source == calcButton)
     {
        //sets the decimal to round to 2 decimals
        String pattern = "###,000.00";
        DecimalFormat df = new DecimalFormat(pattern);

        int index = dropdown.getSelectedIndex();
        String num1 = userP.getText();
        double n1 = Double.parseDouble(num1);
        double n2 = 0.0;
        int n3 = 0;

        //checks if the checkbox is checked or not
        if(isChecked) {
          String num2 = userR.getText();
          String num3 = userT.getText();

          n2 = Double.parseDouble(num2);
          n3 = Integer.parseInt(num3);
        }
        else if(isChecked == false) {
          //gets variables as strings from inputs and converts to double/int
          n2 = Rate[index];
          n3 = Term[index];
        }

        //calculates monthly payment due
        //n1 = principal, n2 = rate, n3 = term
        n2 = n2/1200;
        n3 = n3*12;
        double monthlyPayment = (n1 * n2) / (1 - Math.pow(1+n2,-n3));
 
        //converts total to string
        String output = "$" + df.format(monthlyPayment);

        if((n1 < 0) || (n2 < 0) || (n3 < 0)) {
          output = "Invalid values. Try again";
        }
        //outputs monthly payment
        sum.setText(output);

        double balance = monthlyPayment * n3;
        //string buffer to append to *after* calculate button is clicked
        StringBuffer sb = new StringBuffer();

        //appends heading titles at the top of the JTextArea
        String header = String.format("%10s %30s %30s\n", "Month", "Interest Paid ($)", "Remaining Balance ($)");
        sb.append(header);
        sb.append("\n");

        //loop to output month, monthlyPayment, and remaining balance
        double paidInterest = 0.0;
        for (int i = 1; i <= n3; i++) {
          paidInterest = n1 * n2;
          n1 = n1 - (monthlyPayment - paidInterest);
          if (n1 <= 0) {
            n1 = 0;
          }
          String text = String.format("%10d %30.2f %40.2f\n", i, paidInterest, n1);
          sb.append(text);
        }
        //outputs all text to the JTextArea
        textArea.setText(sb.toString());
      }
      //reset button
      else if(source == reset)
      {
        sum.setText("");
        userP.setText("");
        textArea.setText("");
      }
      else
      {
        // if the user clicks on the Exit button (source is Exit button)
        System.exit(0);
      }
   }// end actionPerformed
}// end JCalcFrame