/**This project will take user Hours worked and the
 * shift they work to calculate their net pay base on their input.
 *
 * Sussana Beanuty Kwabi        Date Created 01/13/2020*/

import java.text.DecimalFormat;
import java.util.Scanner;

public class AcmePay {
	static Scanner inputDevice = new Scanner(System.in);
	static DecimalFormat DollarAmt = new DecimalFormat("$#,###.00");
	static DecimalFormat percent = new DecimalFormat("###.0");
	static final int FIRST_SHIFT = 17;
	static final double SECOND_SHIFT = 18.50;
	static final int THIRD_SHIFT = 22;
	static final double OVER_TIME_PAY = 1.05;
	static final double RETIREMENT_PLAN = .03;
	
	
	

	public static void main(String[] args) {
		
		int  Hours, Shift;
		double Retirement, Rate   ;
		
		Hours = inputHours();
		Shift = inputShift();
		//Retirement = inputRetirement(Shift);
				
		double RegularPay= computeRegularPay(Hours, Shift);
		double OvertimePay= computeOvertimePay(Hours,Shift);
		double RetirementDeduct= computeDeductible(Shift, RegularPay);
		
		double TotRegularANDOvertimePay= 
				computeRegularOvertimePay(RegularPay, OvertimePay);
		
		
		double NetPay= computeNetPay(TotRegularANDOvertimePay, RetirementDeduct);
		
		double ShiftRate = displayShiftRate(Shift);
		
		OutputDisplay(Hours, Shift, ShiftRate, RegularPay, OvertimePay,
				TotRegularANDOvertimePay, RetirementDeduct, NetPay);

	}
	
	
	
	
	// get shift rate for employee
	public static double displayShiftRate(int Shift) {
		double cRate;
		
		if (Shift == 1) {
			cRate = 17;
			return cRate;
		}else {
			if (Shift == 2) {
				cRate = 18.50;
				return cRate;

			} else {

				cRate = 22;
				return cRate;
			}
		}
				

	}

	
	
	//calculate net pay
	public static double computeNetPay
			(double TotRegularANDOvertimePay, double RetirementDeduct) {
		double cNetPay = TotRegularANDOvertimePay + RetirementDeduct;
		return cNetPay;
	}

	
	
	
	
	// calculate deduction 
	public static double computeDeductible(int Shift, double RegularPay) {
		double cRetirementDeduct;
		
		if (Shift == 2) {
			cRetirementDeduct = RegularPay *  RETIREMENT_PLAN;
			return cRetirementDeduct;
		}else {
			cRetirementDeduct = RegularPay * RETIREMENT_PLAN;
			return cRetirementDeduct;
		}
	}
	
	
	//calculate total regular and over time pay
	public static double computeRegularOvertimePay(double RegularPay, double OvertimePay) {
		double TotRegularANDOvertimePay = RegularPay + OvertimePay;
		return TotRegularANDOvertimePay;
	}
	
	
	
	
	// Calculate a overtime 
	public static double computeOvertimePay(int Hours, int Shift) {
		double cOvertimePay;
		if (Hours > 40 && Shift == 1) {
			cOvertimePay = Hours / OVER_TIME_PAY * FIRST_SHIFT;
			return cOvertimePay;
		}else {
			if (Hours > 40 && Shift == 2) {
				cOvertimePay = Hours / OVER_TIME_PAY * SECOND_SHIFT;
				return cOvertimePay;
			}else {
				cOvertimePay = Hours / OVER_TIME_PAY * THIRD_SHIFT;
				return cOvertimePay;
			}
		}
	}
	
	
// calculate regular pay
	public static double computeRegularPay(int Hours, int Shift ) {
		double cRegularPay;
		
			if (Shift == 1) {
				 cRegularPay= Hours * FIRST_SHIFT;
				 System.out.println("First Shift Employee");
				 return cRegularPay;
			}else {
				if (Shift == 2) {
					 cRegularPay= Hours * SECOND_SHIFT;
					 System.out.println("Second Shift Employee");
					 return cRegularPay;
				
			}else {
				 cRegularPay= Hours * THIRD_SHIFT;
				 System.out.println("Third Shift Employee");
				 return cRegularPay;
			}
		}		
	}	

	
    // user input hours
	public static int inputHours() {
				
		System.out.println("Enter your Hours Worked: ");
		String iData = inputDevice.next();
		int iHours = Integer.parseInt(iData);
		return iHours;

	}

	// user input  shift
	public static int inputShift() {
		
		System.out.println("Enter your Shift as (1, 2, 3): ");
		String iData = inputDevice.next();
		int iShift = Integer.parseInt(iData);
		return iShift;

	}
	
	
		
	
	// display all info
	public static void OutputDisplay(int Hours, int Shift, double ShiftRate, double RegularPay, double OvertimePay,	
			double TotRegularANDOvertimePay, double RetirementDeduct, double NetPay) {


		String oShift;

		if(Shift == 1){
			oShift = "First Shift";
		}else{
			if(Shift == 2) {
				oShift = "Second Shift";
			}else{
				oShift = "Third Shift";

			}

		}

		String oRate = DollarAmt.format(ShiftRate);
		String oRegularPay = DollarAmt.format(RegularPay);
		String oOvertimePay = DollarAmt.format(OvertimePay);
		String oTotRegularANDOvertime = DollarAmt.format(TotRegularANDOvertimePay);
		String oRetirement = percent.format(RetirementDeduct);
		String oNetPay = DollarAmt.format(NetPay);



		System.out.println("Hours Worked is : " + Hours);
		System.out.println("Shift is : " + oShift);
		System.out.println("Shift Rate is : " + oRate);
		System.out.println("Your Regular Pay is : " + oRegularPay);
		System.out.println("Your OverTime Pay is : " + oOvertimePay);
		System.out.println("Total Regular and Overtime Pay is : " + oTotRegularANDOvertime);
		System.out.println("Your Retirement Deduction is : " + oRetirement);
		System.out.println("Your Net Pay is  : " + oNetPay);


	}

}
