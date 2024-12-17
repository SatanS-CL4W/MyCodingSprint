class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c :  s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        Queue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
            (a, b) -> Character.compare(b.getKey(), a.getKey())
        );

        pq.addAll(map.entrySet());

        StringBuilder ret = new StringBuilder();
        int pivot = -1;
        while(!pq.isEmpty()) {
            Map.Entry<Character, Integer> node = pq.poll();
            if(pivot == -1 || ret.charAt(pivot) != node.getKey() || ret.length() - pivot < repeatLimit) {
                ret.append(node.getKey());
                node.setValue(node.getValue()-1);
                if(node.getValue()!=0)
                    pq.add(node);
                if(pivot == -1 || ret.charAt(pivot) != node.getKey())
                    pivot = ret.length()-1;
                continue;
            }
            if(pq.isEmpty()) return ret.toString();
            Map.Entry<Character, Integer> node1 = pq.poll();
            ret.append(node1.getKey());
            node1.setValue(node1.getValue()-1);
            if(node1.getValue()!=0)
                pq.add(node1); 
            pq.add(node);
            pivot = ret.length()-1;
        }

        return ret.toString();
    }
}