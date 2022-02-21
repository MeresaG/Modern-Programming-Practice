package lesson4;

public class Paycheck {
	
	private double grossPay;
	private double fica;
	private double state;
	private double local;
	private double medicare;
	private double socialSecurity;
	
	public Paycheck(double grossPay, double fica, double state, double local, double medicare, double socialSecurity) {
		
		
		this.grossPay = grossPay;
		this.fica =  fica;
		this.state = state;
		this.local = local;
		this.medicare = medicare;
		this.socialSecurity = socialSecurity;
		
	}
	
	public void print(){
        System.out.println("------------------------------");
        System.out.println("Gross Payment : " + this.grossPay);
        System.out.printf("Taxes Payment : %.2f \n" ,calculateTaxes());
        System.out.printf("Net Payment  : %.2f \n",  this.getNetPay());
        System.out.println("------------------------------");
    }
    public double getNetPay(){
        return grossPay- calculateTaxes();
    }
    private double calculateTaxes(){
        return grossPay* fica/100 + grossPay*state/100 + grossPay*local/100 + grossPay*medicare/100 + grossPay*socialSecurity/100;
    }

	
	

}
