package com.Learning.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class skipWeekend {

    public static int getDayNumber(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        return day.getValue();
    }

    public static LocalDate getFInalDate(LocalDate dateToBeEvaluated) {
        LocalDate finalDate = dateToBeEvaluated;
        int currentDayOfWeek = getDayNumber(dateToBeEvaluated);
        if (currentDayOfWeek == 6) {
            finalDate = finalDate.plusDays(2);
        }
        if (currentDayOfWeek == 7) {
            finalDate = finalDate.plusDays(1);
        }

        return finalDate;
    }
/*
currentday   Appointmentday
Monday          Thursday
Tuesday         Friday
Wednesday       Monday
Thursday        Tuesday
Friday          Wednesday
Saturday        Thursday
Sunday          Thursday
* */

    /*
     * */

    public static void main(String[] args) {


        int numberOfDaysToAdjust = 3;
        String inputConnectDate = "2021-07-16";

        LocalDate currentDate = LocalDate.now();
 //       currentDate = currentDate.plusDays(4);
 //       System.out.println("currentDate :--->" + currentDate);

        LocalDate requestedDate = LocalDate.now();
         requestedDate = requestedDate.plusDays(10);
        System.out.println("requestedDate:---> " + requestedDate);

        LocalDate connectDate;

        LocalDate finalDate;

        connectDate = LocalDate.parse(inputConnectDate);
        System.out.println("connectDate:---> " + connectDate);

        finalDate = connectDate;

        for (int i = 0; i < numberOfDaysToAdjust; i++) {

            finalDate = getFInalDate(finalDate);

            finalDate = finalDate.plusDays(1);
            finalDate = getFInalDate(finalDate);

        }

        int daysDifferenceFinalAndRequestedDate = finalDate.compareTo(requestedDate);
        if (daysDifferenceFinalAndRequestedDate < 0) {
            finalDate = requestedDate;
        }

        System.out.println("\n adjusted finalDate :--->" + finalDate);

 /*       if (!inputConnectDate.isEmpty()){
            connectDate = LocalDate.parse(inputConnectDate);
            int daysDifferenceConnectAndcurrent = connectDate.compareTo(currentDate);
            int daysDifferenceCurrentAndRequested = currentDate.compareTo(requestedDate);
            int daysDifferenceConnectAndRequestd = connectDate.compareTo(requestedDate);
            // connect date is current date
           if(daysDifferenceConnectAndcurrent == 0){
               // requested date is before current day
               if(daysDifferenceConnectAndRequestd <= 0 ){
                   finalDate = connectDate;
                   noOfDaysToAdd = numberOfDaysToAdjust;
               }else if(daysDifferenceConnectAndRequestd > 0 &&  daysDifferenceConnectAndRequestd < numberOfDaysToAdjust){
                   finalDate = requestedDate;
                   noOfDaysToAdd = numberOfDaysToAdjust - daysDifferenceConnectAndRequestd;
               }else if(daysDifferenceConnectAndRequestd > numberOfDaysToAdjust ){
                   finalDate = requestedDate;
                   noOfDaysToAdd = numberOfDaysToAdjust;
               }
           }  // connect date is before current date
           else if(daysDifferenceConnectAndcurrent <0 ){
                if(daysDifferenceConnectAndRequestd > 0 &&  daysDifferenceConnectAndRequestd < numberOfDaysToAdjust){
                   finalDate = requestedDate;
                   noOfDaysToAdd = numberOfDaysToAdjust - daysDifferenceConnectAndRequestd;
               }else if(daysDifferenceConnectAndRequestd > numberOfDaysToAdjust ){
                   finalDate = requestedDate;
                   noOfDaysToAdd = numberOfDaysToAdjust;
               }
           }



            if(daysDifferenceConnectAndRequestd <= 0 ){
                finalDate = connectDate;
                noOfDaysToAdd = numberOfDaysToAdjust;
            }else if(daysDifferenceConnectAndRequestd > 0 &&  daysDifferenceConnectAndRequestd < numberOfDaysToAdjust){
                finalDate = requestedDate;
                noOfDaysToAdd = numberOfDaysToAdjust - daysDifferenceConnectAndRequestd;
            }else if(daysDifferenceConnectAndRequestd > numberOfDaysToAdjust ){
                finalDate = requestedDate;
                noOfDaysToAdd = numberOfDaysToAdjust;
            }

        }else{
            int daysDifferenceCurrentAndRequested = (int) ChronoUnit.DAYS.between(currentDate, requestedDate);
            if(daysDifferenceCurrentAndRequested <= 0){
                finalDate = currentDate;
                noOfDaysToAdd = numberOfDaysToAdjust;
            }else if(daysDifferenceCurrentAndRequested > 0 &&  daysDifferenceCurrentAndRequested < numberOfDaysToAdjust){
                finalDate = requestedDate;
                noOfDaysToAdd = numberOfDaysToAdjust - daysDifferenceCurrentAndRequested;
            }else if(daysDifferenceCurrentAndRequested > numberOfDaysToAdjust ){
                finalDate = requestedDate;
                noOfDaysToAdd = numberOfDaysToAdjust;
            }


        }*/


/*
        for(int i=0 ; i< noOfDaysToAdd ; i++){

            int finalDayOfWeek = getDayNumber(finalDate);

            if(finalDayOfWeek == 6){
                finalDate = finalDate.plusDays(2);
            }
            if(finalDayOfWeek == 7){
                finalDate = finalDate.plusDays(1);
            }

            finalDate = finalDate.plusDays(1);
            int reFinalDayOfWeek = getDayNumber(finalDate);
            if(reFinalDayOfWeek == 6){
                finalDate = finalDate.plusDays(2);
            }

        }
*/


      /*  if (daysDifference < 0) {
            requestedDate = currentDate;
        }
        int noOfDaysToAdd = 0;


        if (currentDayOfWeek == 1 || currentDayOfWeek == 2) {
            noOfDaysToAdd = 3;
            if (daysDifference >= 3) {
                finalDate = requestedDate;
            } else {
                noOfDaysToAdd = 3 - daysDifference;
                finalDate = requestedDate.plusDays(noOfDaysToAdd);
            }
        } else if (currentDayOfWeek == 3 || currentDayOfWeek == 4 || currentDayOfWeek == 5 || currentDayOfWeek == 6) {
            System.out.println("Current day of week is WED  , Thursday ");
            noOfDaysToAdd = 5;

            if (daysDifference >= 5) {
                finalDate = requestedDate;
            } else {
                noOfDaysToAdd = 5 - daysDifference;
                finalDate = requestedDate.plusDays(noOfDaysToAdd);
            }
        } else if (currentDayOfWeek == 7) {
            noOfDaysToAdd = 4;
            if (daysDifference >= 4) {
                finalDate = requestedDate;
            } else {
                noOfDaysToAdd = 4 - daysDifference;
                finalDate = requestedDate.plusDays(noOfDaysToAdd);
            }
        }*/

        //  System.out.println("FINAL DATE: ----->   " + finalDate);

    }
}
