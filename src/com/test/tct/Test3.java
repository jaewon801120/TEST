package com.test.tct;

import java.util.*;

public class Test3 {

	public static void main(String[] args) {

		int leave = 3;
		String day = "SUN";
		int[] holidays = { 2, 6, 17, 29 };
		Solution3 sol = new Solution3();
		//sol.solution(leave, day, holidays);
		sol.sample(leave, day, holidays);

	}

}

class Solution3 {
	
	public int sample(int leave, String day, int[] holidays) {
        int answer = -1;
        Map<String, Integer> days = new HashMap<>();
        days.put("MON", 0);
        days.put("TUE", 1);
        days.put("WED", 2);
        days.put("THU", 3);
        days.put("FRI", 4);
        days.put("SAT", 5);
        days.put("SUN", 6);

        for (int i = 1; i <= 30 - leave + 1; i++) {
            int temp = 0;
            int leave2 = leave;
            for (int j = i; j <= 30; j++) {
                if (isHoliday(j, day, days, holidays)) {
                    temp++;
                }
                else if (leave2 > 0) {
                    leave2--;
                    temp++;
                }
                else {
                    break;
                }

            }

            answer = Math.max(answer, temp);
        }

        return answer;
    }

    public boolean isHoliday(int date, String day, Map<String, Integer> days, int[] holidays) {
        if (Arrays.stream(holidays).anyMatch(h -> h == date)) return true;
        if ((days.get(day) + date - 1) % 7 == 5 || (days.get(day) + date - 1) % 7 == 6) return true;

        return false;
    }

	public List<Days> list = new ArrayList<>();

	public int[] allDay = new int[30];

	public int solution(int leave, String day, int[] holidays) {
		int answer = -1;
		
		List<Integer> intList = new ArrayList<Integer>();
		for (int i : holidays)
		{
		    intList.add(i);
		}

		String[] mon = { "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN" };
		int find = 0;
		for (int i = 0; i < mon.length; i++) {
			if (mon[i].equals(day)) {
				find = i;
				break;
			}
		}

		int notHol = 0;
		int nmon = find;
		for (int i = 0; i < 30; i++) {
			if (nmon > 6)
				nmon = 0;
			
			boolean bHol = false;
			String dd = mon[nmon];
			if (dd.equals("SUN") || dd.equals("SAT")) {
				bHol = true;
			}
			
			if (intList.contains(i+1)) {
				bHol = true;
			}
			
			Days days = new Days(i+1, mon[nmon], bHol);
			list.add(days);
			
			nmon++;
			if (bHol == false) {
				notHol++;
				allDay[i] = 0;
			}
			else {
				allDay[i] = 1;
			}
		}
		
		for (int i=0; i<notHol; i++) {
			int[] temp = allDay.clone();
			setHol(i, leave, temp);
			int n = getMaxCount(temp);
			if (answer < n) {
				answer = n;
			}
		}
		
		MyUtil.PrintArray(list);
		System.out.println(answer);

		return answer;
	}

	public void setHol(int index, int mount, int[] temp) {
		int notHol = 0;
		int nMount = 0;
		boolean first = false;
		for (int i=0; i<list.size(); i++) {
			Days days = list.get(i);
			if (days != null) {
				if (days.bHol == false) {
					if (first == true || notHol == index) {
						temp[i] = 1;
						nMount++;
						first = true;
					}

					notHol++;
				}
			}
			
			if (nMount == mount)
				return;
		}
	}
	
	public int getMaxCount(int[] temp) {
		int max = 0;
		int sum = 0;
		for (int i=0; i<temp.length; i++) {
			if (temp[i] == 1) {
				sum++;
			}
			else {
				sum = 0;
			}
			
			if (sum > max) {
				max = sum;
			}
		}
		return max;
	}

}

class Days {
	public String dayName;
	public int dayNum;
	public boolean bHol;

	public Days(int dayNum, String dayName, boolean bHol) {
		this.dayNum = dayNum;
		this.dayName = dayName;
		this.bHol = bHol;
	}
	
	@Override
	public String toString() {
		return "Days [dayName=" + dayName + ", dayNum=" + dayNum + ", bHol=" + bHol + "]";
	}

}
