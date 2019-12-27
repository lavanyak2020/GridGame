package com.gridgame;

import java.util.*;
import java.lang.Math.*;

class Grid{
	Ball ball;
	Person person;
	Grid(){
		ball = new Ball((int)(Math.random()*10),(int)(Math.random()*10));
		person = new Person(0,0);
	}
	boolean isPersonReached(){
		if(ball.xCord == person.xCord && ball.yCord == person.yCord){
			return true;
		}
		return false;
	}
	
}
class Ball{
	int xCord;
	int yCord;
	Ball(int xCord,int yCord){
		this.xCord = xCord;
		this.yCord = yCord;
	}
}

class Person{
	int xCord;
	int yCord;
	Person(int xCord,int yCord){
		this.xCord = xCord;
		this.yCord = yCord;
	}
	void movePersonInXDir(){
		xCord ++;
	}
	void movePersonInYDir(){
		yCord ++;		
	}
}
public class Game{
	ArrayList<String> path = new ArrayList<>();
	Grid grid;

	public void startGame(){
		grid = new Grid();
		System.out.println("\n\tBall location:\n\txCord:"+grid.ball.xCord+"  yCord:"+grid.ball.yCord);
		findPath();
		System.out.println("\n****************************");
		for(String step:path){
			System.out.println(step);
		}
		System.out.println("****************************");
	}
	void findPath(){
		while(grid.person.xCord != grid.ball.xCord){
			grid.person.movePersonInXDir();
			path.add(String.format("xCord:%d , yCord:%d",grid.person.xCord,grid.person.yCord));
		}
		while(grid.person.yCord != grid.ball.yCord){
			grid.person.movePersonInYDir();
			path.add(String.format("xCord:%d , yCord:%d",grid.person.xCord,grid.person.yCord));
		}
		
	}
	
}