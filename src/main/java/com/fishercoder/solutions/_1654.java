public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{x,0,1});
        Set<Integer> vis=new HashSet<>();
        Integer lim=x;
        for (int i: forbidden) {vis.add(i); lim=Math.max(lim,i);};
        lim+=a+b;
        while (!queue.isEmpty()){
            int[] temp=queue.poll();
            int curr=temp[0], jumps=temp[1], is_b=temp[2];
            if(curr<0 || curr>lim || vis.contains(curr)) continue;
            vis.add(curr);
            if (curr==0) return jumps;
            if(is_b==1) queue.offer(new int[]{curr+b, jumps+1, 0});
            queue.offer(new int[]{curr-a, jumps+1, 1});
        }
        return -1;
    }