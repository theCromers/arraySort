package hw3_4_1302;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class arraySort {

	public static void main(String args[]) {
		ArrayList<Integer> numList = new ArrayList<Integer>(10000);
		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		for (int i = 0; i < 10000; i++) {
			Integer r = rand.nextInt() % 256;
			numList.add(r);
		}
		bubbleSort(numList);
		mergeSort(numList);
		selectionSort(numList);
		insertionSort(numList);

	}

	public static void bubbleSort(ArrayList<Integer> numList) { // runs at 0(n^2)
		for (int i = 0; i < numList.size() - 1; i++) {
			int element = numList.get(i);
			for (int j = 0; j < numList.size() - 1 - i; j++) {
				int element_2 = numList.get(j);
				if (element_2 > element_2 + 1) {
					int temp = element_2;
					element_2 = element_2 + 1;
					temp = element_2 + 1;

				}

			}
		}
	}

	public static void mergeSort(ArrayList <Integer> numList) {// runs at 0(N log N)
		ArrayList <Integer> temp = new ArrayList();	
		mergeSort(numList, temp, 0, numList.size()-1);
		}

	public static void mergeSort(ArrayList <Integer>numList, ArrayList <Integer>temp, int leftStart, int rightEnd) { 
			if(leftStart>=rightEnd) {
				return;
			}
			int middle = (leftStart+rightEnd)/2;
			mergeSort(numList, temp, leftStart, middle);
			mergeSort(numList, temp, middle+1, rightEnd);
			mergeHalves(numList, temp, leftStart, rightEnd);
		}

	public static void mergeHalves(ArrayList <Integer>numList, ArrayList <Integer> temp, int leftStart, int rightEnd) {
			int leftEnd = (rightEnd+ leftStart)/2;
			int rightStart = leftEnd +1;
			int size = rightEnd-leftStart+1;
			
			int left = leftStart;
			int right = rightStart;
			int index = leftStart;
			
			while(left<= leftEnd && right<= rightEnd) {
				if(numList.get(left)<=numList.get(right)) {
					temp.add(numList.get(left));
					index++;
					left++;
				} else {
					temp.add(numList.get(right));
					right++;
				}
				index++;
			}
		
		}

	public static void selectionSort(ArrayList <Integer>numList) { //runs at 0(n^2)
			for(int i =0; i<numList.size(); i++) {
				int minValue =numList.get(i);
				int minIndex = i;
				for(int j=i; j<numList.size(); j++) {
					if(numList.get(j)< minValue) {
						minValue = numList.get(j);
						minIndex = j;
					}
				}
				if(minValue<numList.get(i)) {
					int temp = numList.get(i);
					numList.set(i, minIndex); //fix
					numList.set(minIndex, temp);
				}
			}
			return;
		}

	public static void insertionSort(ArrayList <Integer>  numList ) {
			int i, j, k, temp;
			
			for(i=1; i<numList.size(); i++) {
				k = numList.get(i);
				j = i-1;
				while(j>=0&&k<numList.get(j)) {
					temp =numList.get(j);
					numList.set(j, j+1);
					numList.set(j+1,temp);
					j--;
				}
			}
			return;
		}
}	