import functions.*;
import functions.basic.*;
import java.io.*;
import functions.TabulatedFunction;
import functions.TabulatedFunctions;

public class Main
{
	public static void main(String[] args) throws InappropriateFunctionPointException
	{
		Function exp = new Exp();
		double step = 0.01;
		double theoreticalValue = Math.exp(1) - Math.exp(0);
		double integral;

		do {
			integral = Functions.integral(exp, 0, 1, step);
			step *= 0.8;
		} while (Math.abs(integral - theoreticalValue) >= 1e-7);

		System.out.println("Теоретическое значение: " + theoreticalValue);
		System.out.println("Вычисленное значение:   " + integral);
		System.out.println("Шаг: " + step);

	}

	public static void printFunctionValues(TabulatedFunction function) // функция для вывода значений функции
	{
		System.out.println("Значения функции:");

		for (int i = 0; i < function.getPointsCount(); i++)
		{
			double x = function.getPointX(i);
			double y = function.getPointY(i);
			System.out.println("f(" + x + ") = " + y);
		}
		System.out.println();
	}
}