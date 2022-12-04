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
 * The {@code Fund} class keep track of the different cash type:
 * loonies ($1), toonies ($2), $5 bill, $10 bill, and the $20 bill.
 * All funds in this program are implemented as instances of this class.
 */
public class Fund {

    /**
     * Money parameter: gives the various cash type a household can have.
     */
    private  int loonies, toonies, bill_of_5$, bill_of_10$, bill_of_20$;

    /**
     * Value parameter: gives the value of each money type.
     * To be used in evaluating how much cash/fund each household possesses.
     * <p>Note: VT is an acronym for value of toonies and similarly is V5$,V10$ and V20$
     * for value of five dollars bill, ten dollars bill and twenty dollars bill
     * respectively. VT has been skipped voluntarily as it has a value of 1 but
     * occupy space for nothing</p>
     */
    private static final int VT = 2, V5$ = 5, V10$=10, V20$ = 20;

    /**
     * Initialises a newly created {@code Fund} object so that it represents zero Funds.
     */
    Fund(){
        this.loonies = 0;
        this.toonies = 0;
        this.bill_of_5$ = 0;
        this.bill_of_10$ = 0;
        this.bill_of_20$ = 0;
    }

    /**
     * Initialises a newly created {@code Fund} object so that it represents
     * the same values as the parameters;
     * @param loonies money that worth 1$
     * @param toonies money that worth 2$
     * @param bill_of_5$ money that worth 5$
     * @param bill_of_10$ money that worth 10$
     * @param bill_of_20$ money that worth 20$
     */
    public Fund(int loonies, int toonies, int bill_of_5$, int bill_of_10$, int bill_of_20$){
        this.loonies = loonies;
        this.toonies = toonies;
        this.bill_of_5$ = bill_of_5$;
        this.bill_of_10$ = bill_of_10$;
        this.bill_of_20$ = bill_of_20$;
    }

    /**
     * Initialises a newly created {@code Fund} object so that it represents
     * the same values as the arguments; in other words,
     * the newly created Fund is a copy of the argument Fund.
     * This may be used if a deep copy of {@code fund} is needed.
     * @param fund
     *         {@code Fund}
     */
    Fund(Fund fund){
        loonies = fund.loonies;
        toonies = fund.toonies;
        bill_of_5$ = fund.bill_of_5$;
        bill_of_10$ = fund.bill_of_10$;
        bill_of_20$ = fund.bill_of_20$;
    }

    /**
     * To access the number of loonies in an {@code Fund} object.
     * @return the number of loonies in an object.
     */
    public  int getLoonies(){return loonies;}

    /**
     * To access the number of toonies in an {@code Fund} object.
     * @return the number of toonies in an object.
     */
    public  int getToonies() {return toonies;}

    /**
     * To access the number of five dollars bill in an {@code Fund} object.
     * @return the number of five dollars bill in an object.
     */
    public  int getBill_of_5$() {return bill_of_5$;}

    /**
     * To access the number of ten dollars bill in an {@code Fund} object.
     * @return the number of ten dollars bill in an object.
     */
    public  int getBill_of_10$() {return bill_of_10$;}

    /**
     * To access the number of twenty dollars bill in an {@code Fund} object.
     * @return the number of twenty dollars bill in an object.
     */
    public  int getBill_of_20$() {return bill_of_20$;}

    /**
     * set the value of the {@code Fund} object loonies to the given parameter.
     * @param loonies
     * number of loonies you want to initialise or reinitialise your object with
     */
    public  void setLoonies(int loonies) {this.loonies = loonies;}

    /**
     * set the value of the {@code Fund} object toonies to the given parameter.
     * @param toonies
     * number of toonies you want to initialise or reinitialise your object with
     */
    public  void setToonies(int toonies) {this.toonies += toonies;}

    /**
     * set the value of the {@code Fund} object five dollars bill to the given parameter.
     * @param bill_of_5$
     * number of 5$ you want to initialise or reinitialise your object with
     */
    public  void setBill_of_5$(int bill_of_5$) {this.bill_of_5$ += bill_of_5$;}

    /**
     * set the value of the {@code Fund} object ten dollars bill to the given parameter.
     * @param bill_of_10$
     * number of 10$ you want to initialise or reinitialise your object with
     */
    public  void setBill_of_10$(int bill_of_10$) {this.bill_of_10$ += bill_of_10$;}

    /**
     * set the value of the {@code Fund} object twenty dollars bill to the given parameter.
     * @param bill_of_20$
     * number of 20$ you want to initialise or reinitialise your object with
     */
    public  void setBill_of_20$(int bill_of_20$) {this.bill_of_20$ += bill_of_20$;}

    /**
     * increase the number of arguments of the {@code Fund} object, in other words
     * adding the number of each money type by the indicated number.
     * @param loonies number of loonies you want to add to your funds
     * @param toonies number of toonies you want to add to your funds
     * @param bill_of_5$ number of 5$ you want to add to your funds
     * @param bill_of_10$ number of 10$ you want to add to your funds
     * @param bill_of_20$ number of 20$ you want to add to your funds
     */
    public  void addFund(int loonies, int toonies, int bill_of_5$, int bill_of_10$, int bill_of_20$){
        this.loonies += loonies;
        this.toonies += toonies;
        this.bill_of_5$ += bill_of_5$;
        this.bill_of_10$ += bill_of_10$;
        this.bill_of_20$ += bill_of_20$;
    }

    /**
     * Calculates the total funds of a given {@code Fund} object by summing
     * the product of the number of the given fund types with their value.
     * <p>Note: no multiplication is required for the loonies as it value is one.</p>
     * @return the total amount of funds based on the number of each money type possesed
     * by a given instance of this class
     */
    public double fundTotal(){
        return this.loonies + this.toonies*VT + this.bill_of_5$*V5$ + this.bill_of_10$*V10$ + this.bill_of_20$*V20$;
    }

    /**
     * In general, the {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * The {@code toString} method for class {@code Fund}
     * returns a string consisting of the count of each fund type
     * @return A string representation of the object
     */
    @Override
    public String toString(){
        return "(" + loonies + " x $1)" + " + "
                + "(" + toonies + " x $2)" + " + "
                + "(" + bill_of_5$ + " x $5)" + " + "
                + "(" + bill_of_10$ + " x $10)" + " + "
                + "(" + bill_of_20$ + " x $20)";
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * @param obj the reference object with which to compare.
     * @return {@code true} if this object is the same as the obj
     * argument; {@code false} otherwise.
     */
    public  boolean equals(Fund obj){
        return this.loonies == obj.loonies &&
                this.toonies == obj.toonies &&
                this.bill_of_5$ == obj.bill_of_5$ &&
                this.bill_of_10$ == obj.bill_of_10$ &&
                this.bill_of_20$ == obj.bill_of_20$;
    }
}
