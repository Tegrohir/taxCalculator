/**
 * Created by Tegrohir on 4/18/2018.
 */
public class NormalCalculator implements ICalculator {
    public int getIncomeUpperLimit(int box){
        switch(box){
            case 1:
                return 20142;
            case 2:
                return 33994;
            case 3:
                return 68507;
            case 4:
                return -1;
            default:
                return 0;
        }
    }

    public double getTaxPercentage(int box){
        switch(box){
            case 1:
                return 36.55;
            case 2:
            case 3:
                return 40.85;
            case 4:
                return 51.95;
            default:
                return 0;
        }
    }
}
