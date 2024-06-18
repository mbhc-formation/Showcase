package tn.mbhc.tudev.codingame.exercices.sorting;

class BubbleSort {
	
	private void swap(int[] data, int firstIndex, int secondIndex) {
		int z = data[firstIndex];
		data[firstIndex] = data[secondIndex];
		data[secondIndex] = z;
	}
	
	void execute(int[] nums) {
		
		long start = System.nanoTime();
		if(nums == null || nums.length == 0) {
			long end = System.nanoTime();
        	System.out.println("sorting took : " + ((end - start) / Math.pow(10, 6)) + " ms");
			return;
		}
		
		if(nums.length == 1) {
			long end = System.nanoTime();
	        System.out.println("sorting took : " + ((end - start) / Math.pow(10, 6)) + " ms");
			return;
		}
		
		int i = 0;
        while(i < nums.length) {
            boolean swapped = false;
            for(int index = 0; index < nums.length -1; index++) {
                if(nums[index] >= nums[index+1]) {
                    swap(nums, index, index+1);
                    swapped = true;
                }
            }
            if(!swapped) {
                break;
            }
            i++;
        }
        long end = System.nanoTime();
        System.out.println("sorting took : " + ((end - start) / Math.pow(10, 6)) + " ms");
	}
}