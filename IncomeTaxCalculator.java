import java.util.Date;

import static java.lang.Integer.max;
import static java.lang.Integer.min;
import static java.lang.StrictMath.round;

public class IncomeTaxCalculator {
    ICalculator calc;
    public IncomeTaxCalculator(){
        setNormalCalculator();
    }


    public int calculateTax() {
        return 0;
    }

    public void setAowCalculator(){
        calc = new AowCalculator();
    }

    public void setNormalCalculator(){
        calc = new NormalCalculator();
    }


    public int incomeInBox(int income){
        if (income <= 0) {
            return 0;
        } else if (income <= calc.getIncomeUpperLimit(1)){
            return 1;
        } else if (income <= calc.getIncomeUpperLimit(2)) {
            return 2;
        } else if (income <= calc.getIncomeUpperLimit(3)) {
            return 3;
        } else {
            return 4;
        }
    }

    public double getTaxPercentage(int box){
        return calc.getTaxPercentage(box);
    }

    public int getIncomeUpperLimit(int box){
        return calc.getIncomeUpperLimit(box);
    }

    public boolean isOld(int _year, int _month, int _day){
        Date curDate = new Date();
        int year = curDate.getYear() + 1900;
        int month = curDate.getMonth() + 1;
        int day = curDate.getDate();


        int leeftijd = year - _year;
        if(month <= _month && day <= _day)
            leeftijd--;

        int maanden = 0;
        if(month <= _month && day < _day)
            maanden = 12 - (_month-month);
        else if(month > _month && day >= _day)
            maanden = month - _month;
      //  else
       //     maanden = (month - _month;

        System.out.println(leeftijd);
        System.out.println(maanden);

        return true;
    }

    public int calculateTax(int income){
        double taxableIncome = income;
        double tax = 0;

        for(int i = 3; i > 0; --i){
            if(taxableIncome > getIncomeUpperLimit(i)){
                double x = taxableIncome - getIncomeUpperLimit(i);
                taxableIncome -= x;
                tax += x * (getTaxPercentage(i+1)/100);
            }
        }

        tax += taxableIncome * (getTaxPercentage(1)/100);

        return (int)round(tax);
    }

}
