package namoo.standardAPI;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

public class CalendarExample {
	public static void main(String[] args) {
		
//		Calendar cal = new GregorianCalendar();
		//현재 OS의 날짜 정보를 가지고 생성하는 메서드(팩토리 메서드)
		Calendar cal = Calendar.getInstance();
		System.out.println(cal instanceof GregorianCalendar);
		System.out.println(cal.toString());
		System.out.println(cal.getTime());
		System.out.println((cal.MILLISECOND));
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1; //month는 0부터 시작함
		int date = cal.get(Calendar.DATE);
		int hour = cal.get(Calendar.HOUR);
		int time = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		System.out.println(cal.getTimeInMillis()); //세계시간 기준으로 1970년 1월 1일 0시 0분 0000밀리세컨드를 기준으로 현재까지 흘러온 시간
		System.out.println(month+","+ date);
		
		
		cal.set(Calendar.YEAR,1986);
		cal.set(1987, 3, 14);
		
		StringBuilder sb = new StringBuilder();
		sb.append(cal.get(Calendar.YEAR)).append("-").append(cal.get(Calendar.MONDAY));
		
		System.out.println(sb);
		
		System.out.println(String.format("%tY", cal));
		System.out.println(String.format("%ty", Calendar.getInstance()));
		System.out.println(String.format("%tA", Calendar.getInstance()));
		System.out.println(String.format("%1$tp %tl", Calendar.getInstance()));
		System.out.println(String.format("%tB", Calendar.getInstance()));
		
		System.out.println(String.format("%1$tF %1$tT", cal));
		
		
		
		
		String hireDate = "1987-03-01";
		
		String quiteDate = "2022-05-31";
		int worksDay =	betweenDay(hireDate, quiteDate);
		System.out.println("근무일수: "+worksDay);
		
		
	}
	
	public static int betweenDay(String hireDate, String quiteDate) {
		//System.out.println(cal.getTimeInMillis())// 1970년부터의 날짜다
		//hiredate를 받아서 인트형으로 바꾼후에, getTime으로 계산해야한다.
				
		
		String[] hire = hireDate.split("-");	
		int[] hired = new int[hire.length];
		
		for (int i = 0; i < hire.length; i++) {
			
			hired[i] = Integer.parseInt(hire[i]);
			
		}
			
		
		int hyear = hired[0];
		int hmonth = hired[1];
		int hdate = hired[2];
		
		
		
		
		String[] quite = quiteDate.split("-");
		
		int[] quited = new int[quite.length];
		
		for (int i = 0; i < quite.length; i++) {
			
			quited[i] = Integer.parseInt(quite[i]);
			
		}
			
		
		
		int qyear = quited[0];
		int qmonth = quited[1];
		int qdate = quited[2];
		
		Calendar today = Calendar.getInstance();
		
		today.set(hyear, hmonth, hdate);
		long htime = today.getTimeInMillis();
		
		today.set(qyear, qmonth, qdate);
		long qtime = today.getTimeInMillis();

		int workDays = (int)((qtime-htime)/(24*60*60*1000));
		return workDays;
		

		
	}
	
	
}
