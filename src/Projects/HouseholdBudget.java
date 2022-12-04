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
 * The {@code HouseholdBudget} class manage all the operations related to the {@code Fund}
 * and {@code Expense} of households
 * All households budgets in this program are implemented as instances of this class.
 */
public class HouseholdBudget {
    /**
     * HouseholdBudget parameters: provides the funds and the list of expenses of
     * a household; since a household will typically have more than one expense, it
     * makes sense to make it an array of expenses.
     */
    private Fund fund;
    private Expense[] expenses;

    /**
     * Initialises a newly created {@code HouseholdBudget} object with defaults value of objects (null).
     */
    HouseholdBudget() {
        fund = null;
        expenses = null;
    }

    /**
     * Initialises a newly created {@code HouseholdBudget} object so that it represents
     * the same values as the parameters.
     * @param fund Represents the funds a household possesses.
     * @param expenses represent the list of expenses a given household have.
     */
    public HouseholdBudget(Fund fund, Expense[] expenses) {
        this.fund = fund;
        this.expenses = expenses;
    }

    /**
     * To get all the expenses in an {@code HouseholdBudget} object.
     * @return the list of expenses possessed by a household.
     */
    public Expense[] getExpenseList() {return  expenses;}

    /**
     * To get the funds in an {@code HouseholdBudget} object.
     * @return the funds possessed by a household.
     */
    public Fund getFund(){return fund;}

    /**
     * comparing this Household total funds to another Household.
     * @param obj the reference object with which to compare.
     * @return {@code true} if this object has the same
     * total funds; {@code false} otherwise.
     * Note: the {@code fundTotal()} method from the {@code Fund} class
     * is being implemented here to find the total funds.
     */
    public boolean areTotalFundsEqual(HouseholdBudget obj) {return fund.fundTotal() == obj.fund.fundTotal();}

    /**
     * comparing this Household funds distribution to another Household,
     * in other works are the number of loonies equal,
     * are the number of toonies equal and son on.
     * @param obj the reference object with which to compare.
     * @return {@code true} if this object has the same
     * funds denomination; {@code false} otherwise.
     * Note: the {@code equals()} method from the {@code Fund} class
     * is being implemented here to check if the denomination of the funds are the same.
     */
    public boolean areFundsTypeEqual(HouseholdBudget obj) {return fund.equals(obj.fund);}

    /**
     * A re-implementation of the {@code fundTotal()} method in the {@code Fund} class
     * @return the total amount of funds in a household
     */
    public double fundTotal() {return fund.fundTotal();}

    /**
     * A method used to know how many expenses do we have in our array
     * @return the number of expenses in the list of expense of a household,
     * this is essentially the length of the array
     */
    public int numberOfExpenses() {return expenses.length;}

    /**
     * A method used to add a new expense to the list.
     *     To add a new expense we follow the following 4 steps
     *     <ol>
     *         <li><b>Step I: </b> we are adding one new expense at the time,
     *         Thus a temporary array with a size one unit bigger is needed.</li>
     *         <li><b>Step II: </b> we need to save our current expenses somewhere,
     *         so why not in our temp array!</li>
     *         <li><b>Step III: </b> making a deep copy of the temp array will not only copy
     *         the elements, but also a copy of the size as well.</li>
     *         <li><b>Step IV: </b> we have a longer array with nothing at the last index
     *         so we just place our new expense there then.</li>
     *     </ol>
     * @param expenseType find more details at {@code Fund} costumed constructor
     * @param amount find more details at {@code Fund} costumed constructor
     * @param businessName find more details at {@code Fund} costumed constructor
     * @param paymentDueMonth find more details at {@code Fund} costumed constructor
     * @param paymentDueDay find more details at {@code Fund} costumed constructor
     * @return The number of expenses in the array after adding a new expense
     */
    public int addNewExpense(String expenseType, double amount, String businessName, int paymentDueMonth, int paymentDueDay) {
        Expense[] temp = new Expense[expenses.length + 1];
        for (int i = 0; i < expenses.length; i++) temp[i] = expenses[i];
        expenses = temp.clone();
        expenses[expenses.length - 1] = new Expense(expenseType, amount, businessName, paymentDueMonth, paymentDueDay);
        return expenses.length;
    }

    /**
     * A method used to remove an expense from the expenses array.
     *     To remove an expense we follow the following 2 steps
     *     <ol>
     *         <li><b>Step I: </b> we are removing an expense,
     *         Thus a temporary array with a size one unit less is needed.</li>
     *         <li><b>Step II: </b> we need to save all our current expenses execept the one
     *         at the specified index so why not in our temp array!</li>
     *     </ol>
     * @param index represent the position of the expense you wish to
     * remove from the list
     * @return {@code true} if this operation was successful;
     * {@code false} if they are no expense in our array.
     */
    public boolean removeExpense(int index) {
        Expense[] temp = new Expense[expenses.length - 1];
        if (expenses.length != 0) {
            for (int i = 0, j = 0; i < expenses.length; i++) {
                if (i == index) {
                    continue;
                } else temp[j++] = expenses[i];
            } // end of for loop
            expenses = temp.clone();
            return true;
        } else return false;
    }

    /**
     * A method used to update the due date of the pavement of an expense.
     * Note: we update a particular expense using the {@code setPaymentDueDay()} method
     * and {@code setPaymentDueMonth()} method as well from the {@code Expense} Class
     * @param day parse in a new day to update the previous one
     * @param month parse in a new month to update the previous one
     * @param index used to target a specific expense among the list
     */
    public void dueDateUpdate(int day, int month, int index) {
        expenses[index].setPaymentDueDay(day);
        expenses[index].setPaymentDueMonth(month);
    }

    /**
     * Method used to add funds to a household budget using the {@code addFund}
     * method implemented in the {@code Fund} Class.
     * @param loonies number of loonies you want to add to your funds.
     * @param toonies number of toonies you want to add to your funds.
     * @param bill_of_5$ number of 5$ you want to add to your funds.
     * @param bill_of_10$ number of 10$ you want to add to your funds.
     * @param bill_of_20$ number of 20$ you want to add to your funds.
     * @return the new total value of the fund of a householdBudget.
     */
    public double addFund(int loonies, int toonies, int bill_of_5$, int bill_of_10$, int bill_of_20$) {
        fund.addFund(loonies, toonies, bill_of_5$, bill_of_10$, bill_of_20$);
        return fund.fundTotal();
    }

    /**
     * indicates whether some other object is has the same
     * total value of fund and the number of expenses this one.
     * @param obj the reference object with which to compare.
     * @return {@code true} if this object has the same total funds and
     * number of expenses as obj argument; {@code false} otherwise.
     */
    public boolean equals(HouseholdBudget obj) {
        return fund.fundTotal() == obj.fund.fundTotal() && expenses.length == obj.expenses.length;
    }

    /**
     *
     * @return A string representation of the HouseholdBudget object
     *     <pre>Note: expenses is a list of expense, thus an iteration true the
     * list is being done here, and since strings are immutable we can
     * print all the expense using one String variable and
     * jumping a line after every expense to make is clear and visible.</pre>
     *     <pre>Note: the fund has been printed using the {@code toString()} method
     * from the {@code Fund} class but an attempt to do so for the expenses
     * will result in printing out the array address and  not the content</pre>
     * The {@code toString} method for class {@code HouseholdBudget}
     * returns a string consisting of the fundsBreakdown and each expense description
     */
    public String toString() {
        String str = "";
        if (expenses.length == 0) {str = "No Expenses" + "\n";}
        else {
            for (Expense expense : expenses) str += expense + "\n";
        }
        return fundsBreakdown() + "\n" + str;
    }

    /**
     * Used to print the fund denomination of a household.
     * @return String representation of the funds for a given household.
     */
    public String fundsBreakdown(){
        return fund.toString();
    }

}