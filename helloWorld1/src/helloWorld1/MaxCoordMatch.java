package helloWorld1;

class Point {
	
	double x,y;
	double angle;
	int pointCount,pendicularPointCount;
}
class angleConfig{
	double angle;
	int occurCount=0;
}
public class MaxCoordMatch {
	Point[] point ;
	Point[] relPoint ;
	Point[] relSecondPoint ;
	angleConfig[] angle;
	angleConfig bestAngle;
	int pointsNum=0,angIndex=0;
	public  void main(String[] args){
		pointsNum = args.length/2;
		point = new Point[pointsNum];
		relPoint= new Point[pointsNum];
		for(int i=0;i<args.length;i+=2)
		{
			point[i].x=Integer.getInteger(args[i]);
			point[i].y=Integer.getInteger(args[i+1]);
		}
		
		for(int i=0;i<pointsNum-1;i++){
			setBasePoint(i);
		}
		
	}
	
	private void setBasePoint(int index){
		for(int i = index+1;i<pointsNum;i++)
			relPoint[i]= calc_angle(point[i],point[index]);
		for(int i = index+1;i<pointsNum;i++){
			angIndex = 0;
			point[index].pointCount= getCommonAngleCount();
			int tempPreCount = getCommonPerpendicularCount(point[i].angle);
			if (tempPreCount>point[i].pendicularPointCount)
				point[i].pendicularPointCount=tempPreCount;
		}
		
	}
	
	private int getCommonPerpendicularCount(double angle){
		int count=0;
		for(int i=0;i<pointsNum;i++)
		{
			setSecondBasePoint(i,angle);		
		}		
		return count;
	}
	
	private int setSecondBasePoint(int index,double angle){
		int count=0;
		for(int i = 0;i<pointsNum;i++)
		{
			relSecondPoint[i]= calc_angle(point[i],point[index]);
			if(Math.abs(relSecondPoint[i].angle-angle)==((Double)90.0) || relSecondPoint[i].angle==0)
				count ++;
			//point[i].pointCount= getCommonAngleCount()+getCommonPerpendicularCount(point[i].angle);
		}
		return count;
		
		
	}
	
	private int getCommonAngleCount()
	{
		//int index=0;
		//int xAngleCount=0;
		//int yAngleCount=0;
		int count=0;
		int zeroCount=0;
		for(int i=0 ;i<pointsNum;i++)
		{
			addAngle(relPoint[i].angle);
		}
		angIndex=0;
		while(angle[angIndex].occurCount!=0)
		{
			
			if(angle[angIndex].angle==0)
				zeroCount=angle[angIndex].occurCount;
			if (angle[angIndex].occurCount>count)
				count = angle[angIndex].occurCount;
			angIndex++;
		}
		return count+zeroCount;
		
	}
	
	private void addAngle(double ang)
	{
		for(int i=0;i<angle.length;i++)
		{
			if(angle[i].angle==ang)
			{
				angle[i].occurCount++;
				break;
			}
			else if (angle[i].occurCount==0)
			{
				angle[i].occurCount++;
				angle[i].angle= ang;
				break;
			}
		}
	}
	
	private Point calc_angle(Point x,Point basePoint){
		
		if(x.x-basePoint.x==0&&x.y-basePoint.y==0)
			x.angle=0;
		else if(x.x-basePoint.x==0)
			x.angle=90;
		else if (x.y-basePoint.y==0)
			x.angle=180;
		else
		{
			//x.Hypotenuse =  Math.sqrt(Math.pow((x.x-basePoint.x),2) + Math.pow((x.y-basePoint.y),2));
			x.angle = Math.atan((x.y-basePoint.y)/(x.x-basePoint.x));
		}
		
		return x;
		
	}
}
