/*
 * Carrie Ward
 * 09/20/2017
 * Version 1.0
 * A java program that calculates a mortgage rate using OOP techniques.
 */

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    
        private double loan = 1.0;  // amount of loan
        private double rate = 2.0;  // interst rate
        private double term = 3.0;  // length of term (in years)
        
        public MortgageCalculator()
        {
            
        }
        
        public MortgageCalculator( double l, double r, double t )
        {
            loan = l;
            rate = r;
            term = t;
        }
        
        public double getLoan()
        {
            return loan;
        }
        
        public double getRate()
        {
            return rate;
        }
        
        public double getTerm()
        {
            return term;
        }
        
        public void setLoan( double amount )
        {
            loan = amount;
        }
        
        public void setRate( double interest )
        {
            rate = interest;
        }
             
        public void setTerm( double year )
        {
            term = year;
        }
        
        public double monthlyPayment( double loan, double rate, double term )
        {
            double payment = (loan * ((rate / 100.0) /12.0)) / (1.0 - Math.pow((((rate / 100.0) / 12.0) + 1.0), -(term * 12.0)));
            return payment;
        }
   
        public String toString()
        {            
            NumberFormat input = NumberFormat.getCurrencyInstance();
            return "Loan amount: " + input.format(loan) + "\nMonthly interest rate: " + rate + "%\nTerm: " + (int)term + " years"
            + "\nThe monthly mortgage payment is: " + input.format(monthlyPayment( loan, rate, term )) + "\n";
        }
   
        public void display()
        {
            System.out.println(this);
        }
    
    
    public static void main(String[] args){
        
        double loan, rate, term;
      
        Scanner in = new Scanner(System.in);
        
        // request and store the loan amount
        System.out.print("Enter loan amount between 100,000 and 2,000,000: ");
        loan = in.nextDouble();
        
        // The loan amount should be between $100,000 and $2,000,000
        while( loan < 100000 || loan > 2000000 )
        {
            System.out.print("The loan amount entered is not within range. "
                    + "Enter loan amount between 100,000 and 2,000,000: ");
            
            loan = in.nextDouble();
        }
        
        // request and store the interest rate
        System.out.print("Enter the annual interest rate: ");
        rate = in.nextDouble();
        
        // The interest rate should not be negative
        while( rate < 0 )
        {
            System.out.print("Enter a positive interest rate only: ");
            
            rate = in.nextDouble();
        }
        
        // request and store the term of the loan
        System.out.print("Enter the term of the loan (in years): ");
        term = in.nextDouble();
        
        // The term should not be negative
        while( term < 0 )
        {
            System.out.print("Enter a positive number of years only: ");
            
            term = in.nextDouble();
        }
        
        // create objects to test the program
        // constructor
        System.out.println("\nTEST #1: ");
        MortgageCalculator calc1 = new MortgageCalculator( loan, rate, term );
        calc1.display();
        
        // constructor
        System.out.println("\nTEST #2: ");
        MortgageCalculator calc2 = new MortgageCalculator( 200000.0, 5.75, 30.0 );
        calc2.display();
        
        System.out.println( "\n" );
        
    } // end main
    
} // end class
