import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class MathUtil {
    public static double correlationCoefficient(List<Double> listX, List<Double> listY){
        if(listX.size() != listY.size()) throw new InputMismatchException();


        int     n            = listX.size();
        double  sumX         = sumOfList(listX);
        double  sumY         = sumOfList(listY);
        double  sumXtimesY   = sumOfXTimesY(listX, listY);
        double  sumXPower2   = sumOfListPower2(listX);
        double  sumYPower2   = sumOfListPower2(listY);

        return (sumXtimesY-(1/n)*sumX*sumY)/(Math.sqrt((sumXPower2-(1/n)*Math.pow(sumX, 2))*(sumYPower2-(1/n)*Math.pow(sumY, 2))));

    }
    public static double sumOfList(List<Double> list){
        double sum = 0;
        for(double element : list){
            sum += element;
        }
        return sum;
    }

    public static double sumOfXTimesY(List<Double> listX, List<Double> listY){
        if(listX.size() != listY.size()) throw new InputMismatchException();
        double sum = 0;
        for(int i = 0; i < listX.size(); i++){
            sum += listX.get(i)*listY.get(i);
        }
        return sum;
    }

    public static double sumOfListPower2(List<Double> list){
        double sum = 0;
        for(double element : (List<Double>) list){
            sum += Math.pow(element, 2);
        }
        return sum;
    }
}
