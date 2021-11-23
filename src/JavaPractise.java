
public class JavaPractise {
	public static int Max;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*int k=1;
		for(int i=0;i<4;i++) 
		{
			for(int j=0;j<4-i;j++) 
			{
				System.out.print(k+"\t");
				k++;
			}
			System.out.println("");
		}
		
		k=1;
		for(int i=1;i<5;i++) 
		{
			
			for(int j=1;j<=i;j++) 
			{
				System.out.print(k+"\t");
				k++;
			}
			System.out.println("");
		}
		
		for(int i=1;i<5;i++) 
		{
			
			for(int j=1;j<=i;j++) 
			{
				System.out.print(j+"\t");
				
			}
			System.out.println("");
		}
		
		k=1;
		for(int i=1;i<4;i++) 
		{
			
			for(int j=1;j<=i;j++) 
			{
				System.out.print(3*k+"\t");
				k++;
			}
			System.out.println("");
		}*/
		
		int[] a= new int[5];
		a[0] = 5;
		a[1] = 4;
		a[2] = 3;
		a[3] = 2;
		a[4] = 1;

		int[] b= {1,2,3,4,5};
		
		for(int i=0;i<a.length;i++) 
		{
			System.out.println(a[i]);
		}
		
		for(int i=0;i<b.length;i++) 
		{
			System.out.println(b[i]);
		}
		
		int[][] c =new int[2][2];
		c[0][0]=1;
		c[0][1]=2;
		c[1][0]=3;
		c[1][1]=4;
		
		System.out.println(c[0][0]);
		System.out.println(c[0][1]);
		System.out.println(c[1][0]);
		System.out.println(c[1][1]);
		
		int[][] d = {{4,5,6},{7,8,9},{10,11,12}};
		
		System.out.println("Multi-Dimensional Array");
		
		for(int i=0;i<d.length;i++) 
		{
			for(int j=0;j<d.length;j++) 
			{
				System.out.println(d[i][j]);	
			}
			
		}
		
        int[][] e = {{4,5,6},{7,8,9}};
		
		System.out.println("Multi-Dimensional Array irregular");
		
		for(int i=0;i<2;i++) 
		{
			for(int j=0;j<3;j++) 
			{
				System.out.println(e[i][j]);	
			}
			
		}
		
		
        int[][] f = {{4,71,5},{31,2,7},{11,1,2}};
        int min=f[0][0];
		
		System.out.println("Multi-Dimensional Array irregular");
		
		for(int i=0;i<3;i++) 
		{
			for(int j=0;j<3;j++) 
			{
				if(f[i][j]<min) 
				{
					min=f[i][j];
					int k=0;
					Max = f[k][j];
					for(k=0;k<3;k++) 
					{
						if(f[k][j]>Max) 
						{
							Max=f[k][j];
							
						}
					}
					
				}
					
			}
			
		}
		System.out.println("Minimum number in the matrix is: "+min);
		System.out.println("Maximum number in the column is: "+Max);
		
		int[][] g = {{4,7,120},{3,4,7},{11,12,600}};
        int max=g[0][0];
		
		System.out.println("Multi-Dimensional Array irregular");
		
		for(int i=0;i<3;i++) 
		{
			for(int j=0;j<3;j++) 
			{
				if(g[i][j]>max) 
				{
					max=g[i][j];
					
				}
					
			}
			
		}
		System.out.println("Minimum number in the matrix is: "+max);
	}

}
