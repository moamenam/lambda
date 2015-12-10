public class PlaneGame {
	class Point {
		
		double x,y;
		double angle;
		int pointCount,pendicularPointCount;
	}
	class angleConfig{
		double angle;
		int occurCount=0;
	}	
	
	Point[] point ;
	Point[] relPoint ;
	Point[] relSecondPoint ;
	angleConfig[] angle;
	angleConfig bestAngle;
	int pointsNum=0,angIndex=0;
	
	
	public int bestShot(int[] x, int[] y) {
		point = new Point[pointsNum];
		relPoint= new Point[pointsNum];
		for(int i=0;i<x.length;i++)
		{
			point[i].x=x[i];
			point[i].y=(y[i]);
		}
		
		for(int i=0;i<pointsNum-1;i++){
			setBasePoint(i);
		}
		int maxPointCount=0;
		for(int i=0;i<pointsNum-1;i++){
			if (point[i].pointCount>maxPointCount)
				maxPointCount = point[i].pointCount;
		}
		return maxPointCount;
	}
	
	private void setBasePoint(int index){
		for(int i = index+1;i<pointsNum;i++)
			relPoint[i]= calc_angle(point[i],point[index]);
		int currentPointCount = 0;
		for(int i = index+1;i<pointsNum;i++){
			angIndex = 0;
			currentPointCount = getCommonAngleCount();
			point[index].pointCount= getCommonAngleCount();
			int tempPreCount = getCommonPerpendicularCount(point[i].angle);
			if (tempPreCount+currentPointCount>point[index].pointCount)
				point[index].pointCount=currentPointCount+tempPreCount;
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
