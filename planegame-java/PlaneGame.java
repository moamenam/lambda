public class PlaneGame {
	class Point {
		
		double x,y;
		double angle=0;
		int pointCount=0;
		boolean hasPrependicular=false;
		Point Clone()
		{
			Point p = new Point();
			p.x=this.x;
			p.y=this.y;
			p.angle=this.angle;
			return p;
		}
	}
	class angleConfig{
		double angle;
		int occurCount=0;
	}	
	
	Point[] point ;
	Point[] relPoint ;
	Point[] relSecondPoint ;
	angleConfig[] angle;
	int pointsNum=0,angIndex=0;
	
	
	public int bestShot(int[] x, int[] y) {
		pointsNum = x.length;
		point = new Point[pointsNum];
		relPoint= new Point[pointsNum];
		relSecondPoint= new Point[pointsNum];
		angle = new angleConfig[pointsNum];
		if(x.length<4)
			return x.length;
		for(int i=0;i<x.length;i++)
		{
			point[i]= new Point();
			point[i].x=x[i];
			point[i].y=(y[i]);
		}
		
		for(int i=0;i<pointsNum-1;i++){
			setBasePoint(i);
			if(point[i].pointCount==pointsNum)
				return pointsNum;
		}
		int maxPointCount=0;
		for(int i=0;i<pointsNum-1;i++){
			if (point[i].pointCount>maxPointCount){
				maxPointCount = point[i].pointCount;
			}
		}
		if(maxPointCount<3)
			return 3;
		return maxPointCount;
	}
	
	private void setBasePoint(int index){
		for(int i = index+1;i<pointsNum;i++)
			relPoint[i]=  calc_angle(point[i],point[index]);
		int currentPointCount = 0;
		for(int i = index+1;i<pointsNum;i++){
			angIndex = 0;
			currentPointCount = getCommonAngleCount(i);
			int tempPreCount = getCommonPerpendicularCount(i+1,relPoint[i].angle);
			if (tempPreCount+currentPointCount>point[index].pointCount)
			{
				if((tempPreCount==0)&&(pointsNum>currentPointCount))
					tempPreCount++;
				point[index].pointCount=currentPointCount+tempPreCount;
			}
		}
	}
	
	private int getCommonPerpendicularCount(int index,double angle){
		int count=0,tempCount =0;
		for(int i=index;i<pointsNum;i++)
		{
			tempCount = setSecondBasePoint(i,angle);
			if (tempCount>count)
				count= tempCount;
		}		
		return count;
	}
	
	private int setSecondBasePoint(int index,double angle){
		int count=0;
		for(int i = index+1;i<pointsNum;i++)
		{
			relSecondPoint[i]= calc_angle(point[i],point[index]);
			if(Math.abs(relSecondPoint[i].angle-angle)==((Double)90.0) || relSecondPoint[i].angle==0)
				count ++;
		}
		if (count>0)
			count++;
		return count;		
	}
	
	private int getCommonAngleCount(int index)
	{
		int count=0;
		int zeroCount=0;
		for(int i=index ;i<pointsNum;i++)
		{
			addAngle(relPoint[i].angle);
		}
		int tempAngIndex=0;
		while(tempAngIndex<angIndex)
		{
			
			if(angle[tempAngIndex].angle==0)
				zeroCount=angle[tempAngIndex].occurCount;
			if (angle[tempAngIndex].occurCount>count)
				count = angle[tempAngIndex].occurCount;
			tempAngIndex++;
		}
		return count+zeroCount+1;
	}
	
	private void addAngle(double ang)
	{
		for(int i=0;i<angle.length;i++)
		{
			if(i>=angIndex)
			{
				angle[i] = new angleConfig(); 
				angle[i].occurCount++;
				angle[i].angle= ang;
				angIndex++;
				break;
			}
			if(angle[i].angle ==ang)
			{
				angle[i].occurCount++;
				break;
			}
		}
	}
	
	private Point calc_angle(Point p,Point basePoint){
		
		Point x = p.Clone();
		if(x.x-basePoint.x==0&&x.y-basePoint.y==0)
			x.angle=0;
		else if(x.x-basePoint.x==0)
			x.angle=90;
		else if (x.y-basePoint.y==0)
			x.angle=180;
		else
			x.angle = Math.toDegrees(Math.atan((x.y-basePoint.y)/(x.x-basePoint.x)));
		
		return x;
		
	}
}
