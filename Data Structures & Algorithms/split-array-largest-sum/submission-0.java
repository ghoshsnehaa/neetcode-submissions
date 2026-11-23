class Solution {
    public int splitArray(int[] nums, int k) {
        int low=max(nums);
        int high=sum(nums);
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int noofstud=countnoofstudents(nums,mid);
            if(noofstud>k)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }

        }
        return low;
        
    }
    private int max(int[] nums)
    {
        int max=nums[0];
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>max)
            {
                max=nums[i];
            }
        }
        return max;
    }
    private int sum(int[] nums)
    {
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
        }
        return sum;
    }
    private int countnoofstudents(int[] nums,int pages)
    {
        int stud=1,pagestudent=0;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            if(pagestudent+nums[i]<=pages)
            {
                pagestudent+=nums[i];
            }
            else
            {
                stud++;
                pagestudent=nums[i];
            }
        }
        return stud;
    } 
    
}