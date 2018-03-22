import javax.swing.*;
import java.awt.event.*;
 
 
class Bank implements ActionListener
{
	JLabel MonthlyPaymentLabel,PrincipleLabel,APRLabel,YearsLabel
	,Times_CompoundLabel,Final_Amount;
    JFrame frame;
    JTextField PrincipleField,APRField,YearsField,Times_CompoundField;
    JButton submit,Compound_Interest,Loan_Monthly,submit_ci;
 
    static double p=0,r=0,n=0,t=0,result=0,result02;
    static String apr="",years="",principle="";
 
    Bank()
    {
        frame=new JFrame("Bank");
        PrincipleField=new JTextField();
        APRField=new JTextField();
        YearsField=new JTextField();
        MonthlyPaymentLabel=new JLabel("Monthly Payment");
        PrincipleLabel=new JLabel("Principle");
        APRLabel=new JLabel("APR");
        YearsLabel=new JLabel("Years");
        submit=new JButton("Submit");
        submit_ci=new JButton("Submit");
        Compound_Interest=new JButton("Compound Interest");
        Loan_Monthly=new JButton("Loan Monthly");
        Times_CompoundField=new JTextField();
        Times_CompoundLabel=new JLabel("Times Compounded per Year");
        Final_Amount=new JLabel("Account Balance");

        Compound_Interest.setBounds(0,0,400,500);
        Loan_Monthly.setBounds(400,0,400,500);
        
        frame.add(Compound_Interest);
        frame.add(Loan_Monthly);
        frame.add(Final_Amount);
        frame.add(PrincipleField);
        frame.add(APRField);
        frame.add(YearsField);
        frame.add(PrincipleLabel);
        frame.add(APRLabel);
        frame.add(YearsLabel);
        frame.add(MonthlyPaymentLabel);
        frame.add(submit);
        frame.add(submit_ci);
        frame.add(Times_CompoundField);
        frame.add(Times_CompoundLabel);
        
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(800,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        
        submit.addActionListener(this);
        submit_ci.addActionListener(this);
        Compound_Interest.addActionListener(this);
        Loan_Monthly.addActionListener(this);
        
    }
        
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==submit) {
            	r=Double.parseDouble(APRField.getText());
            	p=Double.parseDouble(PrincipleField.getText());
            	n=Double.parseDouble(YearsField.getText());
            	n=n*12;
            	r=(r/100)/12;
                result = 1+r;
                result02 = 1+r;
                result = Math.pow(result, n);
                result02 = Math.pow(result02, n);
                result02 = result02*r;
                result = result-1;
                result = result/result02;
                result = p/result;
                MonthlyPaymentLabel.setText("Monthly Payment = "+result);
            }
            if(e.getSource()==Loan_Monthly) {
            	PrincipleField.setBounds(30,70,740,30);
                PrincipleLabel.setBounds(30,40,740,30);
                APRField.setBounds(30,190,740,30);
                APRLabel.setBounds(30,160,740,30);
                YearsField.setBounds(30,130,740,30);
                YearsLabel.setBounds(30,100,740,30);
                MonthlyPaymentLabel.setBounds(30,310,740,30);
                submit.setBounds(30,250,740,30);
                Compound_Interest.setBounds(30,10,370,30);
                Loan_Monthly.setBounds(400,10,370,30);
                
                Times_CompoundLabel.setVisible(false);
                Times_CompoundField.setVisible(false);
                submit_ci.setVisible(false);
                Final_Amount.setVisible(false);
                MonthlyPaymentLabel.setVisible(true);
                submit.setVisible(true);
                
                PrincipleField.setText("");
                APRField.setText("");
                YearsField.setText("");
            }
            if(e.getSource()==Compound_Interest) {
            	PrincipleField.setBounds(30,70,740,30);
                PrincipleLabel.setBounds(30,40,740,30);
                APRField.setBounds(30,190,740,30);
                APRLabel.setBounds(30,160,740,30);
                YearsField.setBounds(30,130,740,30);
                YearsLabel.setBounds(30,100,740,30);
                Final_Amount.setBounds(30,370,740,30);
                submit_ci.setBounds(30,310,740,30);
                Compound_Interest.setBounds(30,10,370,30);
                Loan_Monthly.setBounds(400,10,370,30);
                Times_CompoundField.setBounds(30,250,740,30);
                Times_CompoundLabel.setBounds(30,220,740,30);
               
                Times_CompoundLabel.setVisible(true);
                Times_CompoundField.setVisible(true);
                submit_ci.setVisible(true);
                Final_Amount.setVisible(true);
                MonthlyPaymentLabel.setVisible(false);
                submit.setVisible(false);
                
                PrincipleField.setText("");
                APRField.setText("");
                YearsField.setText("");
                Final_Amount.setText("Account Balance");
                Times_CompoundField.setText("");
            }
            if(e.getSource()==submit_ci) {
            	r=Double.parseDouble(APRField.getText());
            	p=Double.parseDouble(PrincipleField.getText());
            	n=Double.parseDouble(Times_CompoundField.getText());
            	t=Double.parseDouble(YearsField.getText());
            	r=(r/100)/n;
                result = 1+r;
                n=n*t;
                result = Math.pow(result, n);
                result = p*result;
                Final_Amount.setText("Account Balance = "+result);
            }
            
        }
        public static void main(String...s)
        {
            new Bank();
        }
        
    }