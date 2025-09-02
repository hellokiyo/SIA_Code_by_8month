package tesk;

public class AggregateVO {

	String deptName;
	//집게함수
	int maxs,mins,avg;
	
	@Override
	public String toString() {
		return  "부서이름 = " + deptName +
				"최댓값 = " + maxs +
				"최솟값 = " + mins +		
				"평균 = " + avg;
	}
}
