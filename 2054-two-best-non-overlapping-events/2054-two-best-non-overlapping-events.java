public int maxTwoEvents(int[][] events) {
	Arrays.sort(events, (int a[], int b[])->{
		if(a[1] == b[1]){
			return b[2]-a[2];
		}
		return a[1]-b[1];
	});
	int max = 0;
	TreeMap<Integer,Integer> map = new TreeMap<>();
	map.put(0,0);
	for(int[] e:events){
		int earn = e[2];
		earn += map.get(map.floorKey(e[0]-1));
		// System.out.println(e[0]+" "+e[1]+" "+e[2]);
		if(map.get(map.floorKey(e[1])) < e[2]){
			map.put(e[1], e[2]);
		}
		// System.out.println(map);
		max = Math.max(earn, max);
		// System.out.println(max);
	}
	return max;
}