import java.util.Arrays;

public class Get_Median {
   
	
	MaxHeap A;
	MinHeap B;
		
	public Get_Median(int capacity) {
		if(capacity%2==0) {
		this.A=new MaxHeap(capacity/2);
		this.B=new MinHeap(capacity/2);
		}else {
			this.A=new MaxHeap(capacity/2+1);
			this.B=new MinHeap(capacity/2+1);
		}
	}
	
	public void rebalance(MaxHeap a,MinHeap b) {
		if(Math.abs(a.NumberOfitems-b.NumberOfitems)==0) {
			return;
		}else {
			if(a.NumberOfitems>b.NumberOfitems) {
				int transfer = a.Delete();
				b.Add(transfer);
			}else {
				int transfer = b.Delete();
				a.Add(transfer);
			}
		}
		
	}
	public void add(int value) {
		if(A.NumberOfitems==0&B.NumberOfitems==0) {
			A.Add(value);
		}else if(A.NumberOfitems==1&&B.NumberOfitems==0) {
			if(value>A.arr[0]) {
				B.Add(value);
			}else {
				int temp =A.arr[0];
				A.arr[0]=value;
				B.Add(temp);
			}
		}
		else {
			if(value>B.arr[0]) {
				B.Add(value);
			}else {
				A.Add(value);
			}
		}
		rebalance(A,B);
	}
	public int GetMedian() {
			if(A.NumberOfitems+B.NumberOfitems%2!=0&&A.NumberOfitems>B.NumberOfitems) {
				return A.arr[0];
			}else {
				return B.arr[0];
			}
	
		
	}

}
