package basics.geekforgeeks

object CountMoreThanNByKOccurrences {
    /**
     *  Given an Array of size n and a Number k.  Find those numbers which occur more than
     *  n/k times.
     *  e.g. [30,10,20,20,10,20,30,30], k=4 --> n/k = 8/4 = 2.  20 and 30 occur more than 2 times.
     */

    /**
     * Skipping Brute Force.  For Brute force, first sort the array and then count
     * by iterating and comparing to previous element
     */


    fun countOptimalWithHashing(nums: IntArray, k: Int): IntArray {
        if(k > nums.size) return intArrayOf()

        val map = mutableMapOf<Int, Int>()

        for(i in nums){
            map[i] = map.getOrDefault(i, 0) + 1
        }

        val countGreaterThan = nums.size / k
        val output = mutableListOf<Int>()

        for(entry in map.entries) {
            if(entry.value > countGreaterThan) {
                output.add(entry.key)
            }
        }
        return output.toIntArray()
    }

    /**
     *  In case the the nums array is very huge and k is very small,
     *  then the hashmap will be very huge.  Solution to use space optimally
     */
    // Moore's voting algorithm
    // COPY PASTING JAVA SOLUTION AS IT COULD NOT BE SOLVED BY ME.  MAY BE LATER.  SIGH!!!
    fun countOptimalWithBetterMemory(nums: IntArray, k: Int): IntArray {
        // [30,10,20,20,10,20,30,30], k=4
        /*HashMap<Integer,Integer> m=new HashMap<Integer,Integer>();

        for(int i=0;i<n;i++){
            if(m.containsKey(arr[i])){
                int count=m.get(arr[i]);
                m.put(arr[i],count+1);
            }
            else if(m.size()<k-1)
                m.put(arr[i],1);
            else
                for(Map.Entry x:m.entrySet()){
            Integer c=(Integer)x.getValue();
            m.put((Integer)x.getKey(),c-1);
            if((Integer)x.getKey()==0)
                m.remove(x.getKey());}
        }
        for(Map.Entry x:m.entrySet()){
            int count=0;
            for(int i=0;i<n;i++){
            if((Integer)x.getKey()==arr[i])
                count++;

        }
            if(count>n/k)
                System.out.print(x.getKey()+" ");
        }*/
        TODO()
    }

}
