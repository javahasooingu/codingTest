 public static int getTotalX(List<Integer> a, List<Integer> b) {

        TreeSet<Integer> aSet = new TreeSet<>(a);
        Integer[] aArr = aSet.toArray(new Integer[aSet.size()]);

        TreeSet<Integer> bSet = new TreeSet<>(b);
        Integer[] bArr = bSet.toArray(new Integer[bSet.size()]);

        int answer = 0;

        loof:
            for(int i = aArr[aArr.length - 1] ; i <= bArr[0] ; i++){
                for(int aNum : aArr){
                    if(i % aNum != 0){
                        continue loof;
                    } // if
                } // for
                for(int bNum : bArr){
                    if(bNum % i != 0){
                        continue loof;
                    } // if
                } // for
                answer++;
            } // for
        return answer;
    } // getTotalX