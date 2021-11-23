import java.util.Date;
import java.util.Set;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateClass {
	public DateClass() 
	{
		System.out.println("Constructor is invoked");
	}
	
	public DateClass(String a) 
	{
		System.out.println("Parameterized Constructor is invoked");
	}
	
	public void getdata() 
	{
		System.out.println("getData");
	}
	
	public static void get() 
	{
		System.out.println("get");
	}	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Date date = new Date();
		System.out.println(date);
		DateClass ctr = new DateClass();
		DateClass ct = new DateClass("");
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		cal.set(Calendar.DATE, 13);
		System.out.println(sdf.format(cal.getTime()));
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		System.out.println(cal.get(Calendar.MINUTE));
		System.out.println(cal.get(Calendar.AM_PM));
		get();
		ctr.getdata();
	}

}
