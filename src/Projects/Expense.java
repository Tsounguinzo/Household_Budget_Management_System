/*
 * Copyright (c) 2022 Beaudelaire Tsoungui Nzodoumkouo. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under My consent.
 *
 * This code is shared on GitHub in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE.
 *
 * Please contact Me at +1 438 509 3906
 * or LinkedIn: https://www.linkedin.com/in/beaudelaire-tsoungui-nzodoumkouo-809744231
 * if you need additional information or have any questions.
 */

package Projects;

/**
 * The {@code Expense} class keep track of the expense type (purchase, bill, etc....),
 * the amount, the name of the business, and the due date
 * All expenses in this program are implemented as instances of this class.
 */
public class Expense {

    /**
     * expense parameters: gives the description a household can have.
     * <p>Note: the expenseType, businessName and amount of an expense are set final
     * this is because the value of this <i>expense parameters</i> are only set once, during the creation
     * of the expense by the user.</p>
     */
    private final String expenseType, businessName;
    private final double amount;
    private  int paymentDueMonth, paymentDueDay;

    /**
     * Initialises a newly created {@code Expense} object with defaults value provided by the java.
     */
    Expense(){
        expenseType = null;
        amount = 0.0;
        businessName = null;
        paymentDueMonth = 0;
        paymentDueDay = 0;
    }

    /**
     * Initialises a newly created {@code Expense} object so that it represents
     * the same values as the parameters.
     * @param expenseType It specifies which kind of expense was made
     * @param amount It represents the value in money of the expense.
     * @param businessName It represents the Name of the company where the transaction was made.
     * @param paymentDueMonth
     * the due month parsed in as an argument is being validated to be on the interval 01 to 12
     * by the {@code setPaymentDueMonth()} setPaymentDueMonth method.
     * @param paymentDueDay
     * the due day parsed in as an argument is being validated to be on the interval 01 to 31
     * by the {@code setPaymentDueDay()} setPaymentDueDay method.
     */
    public Expense(String expenseType, double amount, String businessName, int paymentDueMonth,int paymentDueDay ){
        this.expenseType = expenseType;
        this.amount = amount;
        this.businessName = businessName;
        setPaymentDueMonth(paymentDueMonth);
        setPaymentDueDay(paymentDueDay);
    }

    /**
     * Initialises a newly created {@code Expense} object so that it represents
     * the same values as the arguments; in other words,
     * the newly created Expense is a copy of the argument expense.
     * This may be used if a deep copy of {@code expense} is needed.
     * @param expense
     *         {@code Expense}
     */
    Expense(Expense expense){
        expenseType = expense.expenseType;
        amount = expense.amount;
        businessName = expense.businessName;
        paymentDueMonth = expense.paymentDueMonth;
        paymentDueDay = expense.paymentDueDay;
    }

    /**
     * To get the name of the expense in an {@code Expense} object.
     * @return the name of the expense.
     */
    public String getExpenseType() {return expenseType;}

    /**
     * To get the cost of the expense in an {@code Expense} object.
     * @return the amount of an expense.
     */
    public double getAmount() {return amount;}

    /**
     * To get the name of the business where the expense
     * was made in an {@code Expense} object.
     * @return the business where the expense was made.
     */
    public String getBusinessName() {return businessName;}

    /**
     * To get the day on which expense payment is due.
     * @return the expense payment due day.
     */
    public int getPaymentDueMonth() {return paymentDueMonth;}

    /**
     * To get the day on which expense payment is month.
     * @return the expense payment due month.
     */
    public int getPaymentDueDay() {return paymentDueDay;}

    /**
     * Used to reassign a value to the expense payment due month.
     * This method will be used to update the due date of an expense.
     * Note: the method actually validate if the month is between 01 and 12
     * which are the 12 month of a year.
     * @param paymentDueMonth Represents the month you want to update to.
     */
    public  void setPaymentDueMonth(int paymentDueMonth) {
        this.paymentDueMonth = (paymentDueMonth>=1 && paymentDueMonth<=12)? paymentDueMonth : 0;
    }

    /**
     * Used to reassign a value to the expense payment due day.
     * This method will be used to update the due date of an expense.
     * Note: the method actually validate if the days are between 01 and 31,
     * but it doesn't take in consideration the fact that some months has less than
     * 31 days (my bad)
     * @param paymentDueDay Represents the day you want to update to.
     */
    public  void setPaymentDueDay(int paymentDueDay) {
        this.paymentDueDay = (paymentDueDay>=1 && paymentDueDay<=31)? paymentDueDay : 0;;
    }

    /**
     * A method used to add prefix to number less than 10
     * @param num Represents the number you wish to add a zero prefix to
     * @return A string from the integer input with the zero prefix
     * provided that the number is less than 10
     * Note: we return a string because this method will be implemented in the
     * toString method {@code toString()} which is of string return type
     */
    private String addPrefixZero(int num){return num < 10 ? "0" + num : String.valueOf(num);}

    /**
     * In general, the {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * The {@code toString} method for class {@code Expense}
     * returns a string consisting of the expense description
     * @return A string representation of the object
     * Note: we have called the addPrefixZero method {@code addPrefixZero()}
     * on the payment due date and month to add a prefix in case they are less than 10
     */
    @Override
    public String toString(){
        return "" + expenseType + " - "
                + "$" + amount + " - "
                +  businessName + " - "
                + addPrefixZero(paymentDueDay) + "/" + addPrefixZero(paymentDueMonth) + ".";
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * @param obj the reference object with which to compare.
     * @return {@code true} if this object is the same as the obj
     * argument; {@code false} otherwise.
     */
    public boolean equals(Expense obj){
        return this.expenseType.equals(obj.expenseType) &&
                this.amount == obj.amount &&
                this.businessName.equals(obj.businessName) &&
                this.paymentDueDay == obj.paymentDueDay &&
                this.paymentDueMonth == obj.paymentDueMonth;
    }
}

