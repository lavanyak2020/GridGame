

import java.util.*;
import java.lang.Math.*;

class Grid{
	CoordinatePoint ball;
	CoordinatePoint person;
	Grid(CoordinatePoint ball,CoordinatePoint person){
		this.ball = ball;
		this.person = person;
	}
	boolean isPersonReached(){
		if(ball.xCord == person.xCord && ball.yCord == person.yCord){
			return true;
		}
		return false;
	}
	boolean movePersonInXDir(){
		if(ball.xCord > person.xCord){
			person.xCord ++;
			return true;
		}return false;
		
	}
	boolean movePersonInYDir(){
		if(ball.yCord > person.yCord){
			person.yCord ++;
			return true;
		}
		return false;		
	}
}
class CoordinatePoint{
	int xCord;
	int yCord;
	CoordinatePoint(int xCord,int yCord){
		this.xCord = xCord;
		this.yCord = yCord;
	}
}


class Game{
	ArrayList<String> path = new ArrayList<>();
	Grid grid;

	void startGame(){
		CoordinatePoint b = new CoordinatePoint((int)(Math.random()*10),(int)(Math.random()*10));
		CoordinatePoint p = new CoordinatePoint(0,0);
		grid = new Grid(b,p);

		System.out.println("\n\tBall location:\n\txCord:"+b.xCord+"  yCord:"+b.yCord);
		findPath();
		System.out.println("\n****************************");
		for(String step:path){
			System.out.println(step);
		}
		System.out.println("****************************");
	}
	void findPath(){
		while(grid.movePersonInXDir()){
			path.add(String.format("xCord:%d , yCord:%d",grid.person.xCord,grid.person.yCord));
		}
		while(grid.movePersonInYDir()){
			path.add(String.format("xCord:%d , yCord:%d",grid.person.xCord,grid.person.yCord));
		}
		
	}
	
}
public class GameLauncher{

	public static void main(String args[]){
		Game gridGamer = new Game();
		gridGamer.startGame();
	}
}