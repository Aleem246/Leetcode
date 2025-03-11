class Solution {
    public int numberOfSubstrings(String s) {
        int strt=0,n= s.length();
        int a=0,b=0,c=0,count=0;
        for(int end=0; end<n; end++){
            char C = s.charAt(end);
            if(C=='a')
                a++;
            else if(C=='b')
                b++;
            else
                c++;
            while(a>=1 && b>=1 && c>=1){
                // System.out.println(n-end);
                count+= n-end;
                char strtc = s.charAt(strt);
                if(strtc=='a')
                    a--;
                else if(strtc=='b')
                    b--;
                else
                    c--;
                    
                strt++; 
            }

        }
        return count;
        
    }
}