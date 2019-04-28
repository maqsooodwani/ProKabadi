package main;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		int numberOfTeams=Integer.parseInt(args[0]);
		Main main=new Main();
		System.out.println("PRO-Kabaddi schedule Phase1# Home");
		main.generateHomeSchedule(numberOfTeams);
		System.out.println("PRO-Kabaddi schedule Phase2# Away");
		main.generateHomeSchedule(numberOfTeams);
	}

	/**
	 * @param numberOfTeams
	 * logic to generate proKabbadi schedule
	 */
	void generateHomeSchedule(int numberOfTeams) {
		List<String> teams=new ArrayList<String>();
		getTeamNames(teams,numberOfTeams);
		for(int i=0,j=1,k=0;k<numberOfTeams;k++) {
			System.out.println("Day "+(k+1)+" : "+teams.get(i)+" <--> "+teams.get(j));
			if(i==numberOfTeams-1&&j==0) {
				i=1;
				j=2;
				continue;
			}
			if(j==2&&numberOfTeams%2==0) {
				i=i+2;
				j=j+2;
				if(!(j<=numberOfTeams-1)){
					j=0;
				}
				continue;
			}
			i=i+2;
			j=j+2;
			if(!(i<numberOfTeams-1)&&(i%2==0)&&!(numberOfTeams%2==0)) {
				i=numberOfTeams-1; 
			}else if(numberOfTeams%2==0&&!(i<numberOfTeams-1)) {
				i=1;
			}
			if(!(j<=numberOfTeams-2)&&(i%2==0)&&!(numberOfTeams%2==0)) {
				j=0;
			} else if(numberOfTeams%2==0&&!(j<=numberOfTeams-1)) {
				j=2;
			}
		}
		
		int m=0;
		if(numberOfTeams%2==0) {
			m=numberOfTeams-1;
		}else {
			m=numberOfTeams-2;
		}
		int counter=2;
		while(counter<m) {
			for(int i=0,j=counter,k=0;k<numberOfTeams;k++) {
				System.out.println("Day "+(k+numberOfTeams+1)+" : "+teams.get(i)+" <--> "+teams.get(j));
				i=i+1;
				j=j+1;
				if(!(j<numberOfTeams)) {
					j=0;
				}
			}
			counter++;
		}
	}

	/**
	 * @param teams
	 * @param numberOfTeams
	 * generateTeamNames
	 */
	public void getTeamNames(List<String> teams,int numberOfTeams) {
		for(int i=0;i<numberOfTeams;i++) {
			teams.add("Team"+(i+1));
		}
	}
}
