package com.example.administrator.mondayschild;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class mondaysChild {

    private int iDOW;
    private int iMonth;
    private int iYear;
    private int iDayOfWeek;

    private String sDOW;
    private String sLineFromPoem;
    private String[] saLinesOfPoem;
    private String[] saDOW;
    private String sOutputMsg;

    private void setiDOW(int isDOW)
    {
        this.iDOW = isDOW;
    }

    private int getiDOW()
    {
        return iDOW;
    }

    private void setiMonth(int isMonth)
    {
        this.iMonth = isMonth;
    }

    public int getiMonth()
    {
        return iMonth;
    }

    private void setiYear(int isYear)
    {
        this.iYear = isYear;
    }

    public int getiYear()
    {
        return iYear;
    }

    private void setiDayOfWeek(int siDayOfWeek)
    {
        this.iDayOfWeek = siDayOfWeek;
    }

    public int getiDayOfWeek()
    {
        return iDayOfWeek;
    }

    private void setsDOW(int iDay)
    {
        this.sDOW = saDOW[iDay];
    }

    public String getsDOW()
    {
        return sDOW;
    }

    private void setsLineFromPoem(int iPoemLine)
    {
        this.sLineFromPoem = saLinesOfPoem[iPoemLine];
    }

    public String getsLineFromPoem()
    {
        return sLineFromPoem;
    }

    private void setSaLinesOfPoem()
    {
        saLinesOfPoem = new String[7];
        saLinesOfPoem[0] = "And the child that is born on the Sabbath day, is bonny and blithe and good and gay.";
        saLinesOfPoem[1] = "Mondays child is fair of face";
        saLinesOfPoem[2] = "Tuesdays child is full of grace.";
        saLinesOfPoem[3] = "Wednesdays child is full of woe.";
        saLinesOfPoem[4] = "Thursdays child has far to go";
        saLinesOfPoem[5] = "Fridays child is loving and giving";
        saLinesOfPoem[6] = "Saturdays child works hard for his living";
    }

    public String[] getSaLinesOfPoem()
    {
        return saLinesOfPoem;
    }

    private void setSaDOW()
    {
        saDOW = new String[7];
        saDOW[0] = "Sunday";
        saDOW[1] = "Monday";
        saDOW[2] = "Tuesday";
        saDOW[3] = "Wednesday";
        saDOW[4] = "Thursday";
        saDOW[5] = "Friday";
        saDOW[6] = "Saturday";
    }

    public String[] getSaDOW()
    {
        return saDOW;
    }

    private void setsOutputMsg(String sOutputMsg)
    {
        this.sOutputMsg = sOutputMsg;
    }

    public String getsOutputMsg()
    {
        return sOutputMsg;
    }

    public mondaysChild()
    {
        setSaDOW();
        setSaLinesOfPoem();
        Calendar cCal = Calendar.getInstance();
        setiDOW((cCal.get(Calendar.DAY_OF_WEEK)));
        setiMonth(cCal.get(Calendar.MONTH));
        setiYear(cCal.get(Calendar.YEAR));
    }

    public mondaysChild(int mcDOW, int mcMonth, int mcYear)
    {
        setSaDOW();
        setSaLinesOfPoem();

        setiDOW(mcDOW);
        setiMonth(mcMonth);
        setiYear(mcYear);

        GregorianCalendar gcBDay = new GregorianCalendar(mcYear, mcMonth, mcDOW);

        setiDayOfWeek(gcBDay.get(Calendar.DAY_OF_WEEK) - 1);
        setsDOW(getiDayOfWeek());

        setsLineFromPoem(getiDayOfWeek());

        String sTempStr = "You were born on a " + getsDOW() + "\n" + getsLineFromPoem();
        setsOutputMsg(sTempStr);
    }
}
