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
 * The {@code BudgetDemo} class is used to test all other three classes which are
 * the {@code Fund}, {@code Expense} and the {@code HouseholdBudget} class.
 * Note: This class is also called the driver class.
 * This class is implementing the methods defined in the aforementioned classes
 */

import java.util.Scanner;

public class BudgetDemo {

    /**
     * Instantiating two scanner objects;
     * the first {@code Scanner} object called "IntInput"
     * is used exclusively for Integers data types while the other, "StringInput"
     * is  used exclusively for string literals.
     * Note: We use two scanner object in other to avoid
     * the continues clearance of the String buffer.
     */
    private static Scanner IntInput = new Scanner(System.in);
    private static Scanner StringInput = new Scanner(System.in);

    /**
     * This method is used to check if the number entered
     * is between 0 and 4 inclusive (0 to 4) being the number of
     * houseHoldBudget hardcoded in our program.
     * @param houseHoldIndex
     * the index of the given household budget from the array of household budgets.
     * @return the index of the given household budget
     */
    private static int houseHoldBudgetValidation(int houseHoldIndex){
        while (houseHoldIndex<0 || houseHoldIndex>4){
            System.out.print("Sorry but there is no HouseholdBudget number " + houseHoldIndex +
                    "\n--> Try again: (Enter number 0 to 4): "); // error message and prompting a new input
            houseHoldIndex = IntInput.nextInt();
        }
        return houseHoldIndex;
    }

    /**
     * This method is used to check if a household budget contains an expense
     * in his list of expenses with the provided expense index
     * @param expenseIndex
     * the index of the given expense from the list of expenses in a household budgets.
     * @param houseHoldIndex
     * the index of the given household budget from the array of household budgets.
     * @param listOfHouseholdBudget
     * the list of all the household budgets
     * @return the index of the given expense in the
     * list of expenses in the chosen household budget
     */
    private static int expensesValidation(int expenseIndex, int houseHoldIndex, HouseholdBudget[] listOfHouseholdBudget) {
        while (expenseIndex < 0 || expenseIndex >= listOfHouseholdBudget[houseHoldIndex].numberOfExpenses()) {
            System.out.println("Sorry but there is no expense number " + expenseIndex +
                    "\n--> Try again: " +
                    "\n(Enter number 0 to " + (listOfHouseholdBudget[houseHoldIndex].numberOfExpenses() - 1) + "):");
            expenseIndex = IntInput.nextInt();
        }
        return expenseIndex;
    }

    /**
     * method used to compare if two household budget has the same "total amount of fund",
     * "total fund denominations" and " amount of funds and number of expenses".
     * After comparing the households budget, the pairs satisfying the criteria are printed.
     * @param sameWhat the criteria to be tested for.
     * @param listOfHouseholdBudget the list of household budgets we what to compare its members.
     */
    private static void printHouseholdBudgetWithSame(String sameWhat , HouseholdBudget[] listOfHouseholdBudget){
        for(int j = 0; j<listOfHouseholdBudget.length; j++){
            for(int k = j+1; k<listOfHouseholdBudget.length; k++){
                switch (sameWhat){

                    case "3": // same total amount of fund
                        if(listOfHouseholdBudget[j].areTotalFundsEqual(listOfHouseholdBudget[k]))
                        {System.out.println("\tHouseholdBudgets " + j + " and " + k + " both have " + listOfHouseholdBudget[j].fundTotal());}
                        break;

                    case "4": // same total fund denominations
                        if(listOfHouseholdBudget[j].areFundsTypeEqual(listOfHouseholdBudget[k]))
                        {System.out.println("\tHouseholdBudgets " + j + " and " + k + " both have " + listOfHouseholdBudget[k].fundsBreakdown());}
                        break;

                    case "5": // same amount of funds and number of expenses
                        if(listOfHouseholdBudget[j].equals(listOfHouseholdBudget[k]))
                        {System.out.println("\tHouseholdBudgets " + j + " and " + k );}
                        break;
                }}}}

    // main() Door of entry to the program
    public static void main(String[] args) {


        // Variables declaration
        String mainInput, expenseType, businessName;
        HouseholdBudget H0, H1, H2, H3, H4;
        Fund F1, F2, F3, F4, F5;
        Expense E1, E2, E3, E4, E5, E6, E7;
        Expense[] L1, L2, L3, L4, L5;
        int houseHoldIndex,expenseIndex,paymentDueDay, paymentDueMonth;
        double amount;
        int loonies, toonies, $5, $10, $20;

        // welcome  message
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n" +
                "Welcome to COMP248 Geek's HouseholdBudget_2022 Application\n\n" +
                "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        // Hardcoding the householdBudgets in the driver ; this way we wonâ€™t need to enter
        // all of this information from the keyboard every time we test the program.
        //HouseholdBudget #0
        F1 = new Fund(0,1,0,2,1);
        E1 = new Expense("Purchase", 85.5, "IGA",  11, 25);
        E2 = new Expense("Bill",122.75,"Videotron",12,2);
        L1 = new Expense[]{E1, E2};
        H0 = new HouseholdBudget( F1, L1);

        //HouseholdBudget #1
        F2 = new Fund(F1);
        E3 = new Expense(E1);
        E4 = new Expense("Bill",16.2,"Cotsco",11,23);
        L2 = new Expense[]{E3,E4};
        H1 = new HouseholdBudget(F2,L2);

        //HouseholdBudget #2
        F3 = new Fund(2,0,2,1,1);
        E5 = new Expense("Purchase", 50.75, "Pharmaprix",  12, 1);
        E6 = new Expense("Purchase", 16.2, "TheBay",  12, 16);
        E7 = new Expense("Bill", 65.85, "Fido",  1, 5);
        L3 = new Expense[]{E5,E6,E7};
        H2 = new HouseholdBudget(F3,L3);

        //HouseholdBudget #3
        F4 = new Fund(2,1,2,1,5);
        L4 = new Expense[0];
        H3 = new HouseholdBudget(F4,L4);

        //HouseholdBudget #4
        F5 = new Fund(F4);
        L5 = new Expense[0];
        H4 = new HouseholdBudget(F5,L5);

        // creating an array of the 5 aforementioned objects to facilitates manipulation
        HouseholdBudget[] listOfHouseholdBudget = {H0, H1, H2, H3, H4};

        // keep prompting the user till case O (exit point) is called
        while (true){

            // various task of the program with the corresponding code of execution
            System.out.println("\nWhat would you like to do?\n" +
                    "1. See the possessions of all householdBudgets\n" +
                    "2. See the possessions of one householdBudget\n" +
                    "3. List householdBudgets with same total amount of fund\n" +
                    "4. List householdBudgets with same fund denomination(s)\n" +
                    "5. List householdBudgets with same total amount of fund and same number of expenses\n" +
                    "6. Add an expense to an existing householdBudget\n" +
                    "7. Remove an existing expense from a householdBudget\n" +
                    "8. Update the payment due date of an existing expense\n" +
                    "9. Add fund to a householdBudget\n" +
                    "0. To quit\n");

            System.out.print("Please enter your choice and press <Enter>:");  // prompting for input
            mainInput = StringInput.nextLine(); // input of type String to avoid program crash

            switch(mainInput.strip()) {
                case "1": // printing out the content of each household budget.
                    System.out.print("Content of each HouseholdBudget:\n" +
                            "----------------------");
                    int i = 0;
                    for(HouseholdBudget print : listOfHouseholdBudget ) {
                        System.out.print("\nHouseholdBudget #" + i + ":\n" + print);
                        i++;
                    }
                    break;

                case "2": // printing out the content of the chosen household budget.
                    System.out.print("Which HouseholdBudget you want to see the possessions of? (Enter number 0 to 4): ");
                    houseHoldIndex = IntInput.nextInt();
                    houseHoldIndex = houseHoldBudgetValidation(houseHoldIndex);
                    System.out.print(listOfHouseholdBudget[houseHoldIndex]);
                    break;

                case "3": // printing out the pairs of household budget with same total funds.
                    System.out.println("List of HouseholdBudgets with same total fund:\n");
                    printHouseholdBudgetWithSame(mainInput,listOfHouseholdBudget);
                    break;

                case "4":// printing out the pairs of household budget with same funds denomination(s).
                    System.out.println("List of HouseholdBudgets with same fund:\n");
                    printHouseholdBudgetWithSame(mainInput,listOfHouseholdBudget);
                    break;

                case "5": // printing out the pairs of household budget with same total funds and number of expenses.
                    System.out.println("List of HouseholdBudgets with same amount of money and same number of expenses:\n");
                    printHouseholdBudgetWithSame(mainInput,listOfHouseholdBudget);
                    break;

                case "6": // adding an expense to the chosen household budget.
                    System.out.print("Which HouseholdBudget do you want to add an Expense to? (Enter number 0 to 4): ");
                    houseHoldIndex = IntInput.nextInt();
                    houseHoldIndex = houseHoldBudgetValidation(houseHoldIndex);
                    System.out.println("Please enter the following information so that we may complete the expense-");
                    System.out.print("--> Type of expense(Bill, Purchase, etc ...): "); expenseType = StringInput.nextLine();
                    System.out.print("--> Amount of the expense: ");  amount = IntInput.nextDouble();
                    System.out.print("--> Name of the business: ");  businessName = StringInput.nextLine();
                    System.out.print("--> Payment due day number and month (separate by a space): ");  paymentDueDay = IntInput.nextInt() ; paymentDueMonth = IntInput.nextInt();
                    System.out.println("You now have " + listOfHouseholdBudget[houseHoldIndex].addNewExpense(expenseType,amount,businessName,paymentDueMonth,paymentDueDay) + " expense");
                    break;

                case "7": // removing an expense from the chosen household budget iff it contains at least one expense.
                    System.out.print("Which HouseholdBudget do you want to remove an expense from? (Enter number 0 to 4): ");
                    houseHoldIndex = IntInput.nextInt();
                    houseHoldIndex = houseHoldBudgetValidation(houseHoldIndex);
                    if(listOfHouseholdBudget[houseHoldIndex].numberOfExpenses() == 0) System.out.println("Sorry that HouseholdBudget has no expenses");
                    else { System.out.println("(Enter number 0 to " + (listOfHouseholdBudget[houseHoldIndex].numberOfExpenses()-1) + "):");
                        expenseIndex = IntInput.nextInt();
                        expenseIndex = expensesValidation(expenseIndex,houseHoldIndex,listOfHouseholdBudget);
                        listOfHouseholdBudget[houseHoldIndex].removeExpense(expenseIndex);
                        System.out.println("Expense was removed successfully"); }
                    break;

                case "8": // updating the payment of a chosen expense from a chosen household budget
                    System.out.print("Which HouseholdBudget do you want to update an expense from? (Enter number 0 to 4): ");
                    houseHoldIndex = IntInput.nextInt();
                    houseHoldIndex = houseHoldBudgetValidation(houseHoldIndex);
                    System.out.println("Which expense do you want to update? " + "(Enter number 0 to " + (listOfHouseholdBudget[houseHoldIndex].numberOfExpenses()-1) + "):");
                    expenseIndex = IntInput.nextInt();
                    expenseIndex = expensesValidation(expenseIndex,houseHoldIndex,listOfHouseholdBudget);
                    System.out.print("--> Enter new payment due day number and month (separated by a space): ");
                    paymentDueDay = IntInput.nextInt(); paymentDueMonth = IntInput.nextInt();
                    listOfHouseholdBudget[houseHoldIndex].dueDateUpdate(paymentDueDay, paymentDueMonth, expenseIndex);
                    System.out.println("Due Date updated");
                    break;

                case "9": // to add funds to a chosen household budget
                    System.out.print("Which HouseholdBudget do you want to add Fund to? (Enter number 0 to 4): ");
                    houseHoldIndex = IntInput.nextInt();
                    houseHoldIndex = houseHoldBudgetValidation(houseHoldIndex);
                    System.out.println("How many loonies, toonies,$5,$10 and $20 bill do you want to add?");
                    System.out.print("Enter 5 numbers separated by a space): ");
                    loonies = IntInput.nextInt(); toonies = IntInput.nextInt(); $5 = IntInput.nextInt(); $10 = IntInput.nextInt(); $20 = IntInput.nextInt();
                    System.out.println("You now have $" + listOfHouseholdBudget[houseHoldIndex].addFund(loonies,toonies,$5,$10,$20));
                    break;

                case "0": // ending the program
                    System.out.println("Thank you for using COMP248 Geek's HouseholdBudget application!");
                    System.exit(0);
                    break;

                default: // message in case of invalid code of execution
                    System.out.println("sorry that is not a valid choice. Try again.");
                    break;

            }//end of switch()
        } //end of while()
    }//end of main()
}// end Demo Class
